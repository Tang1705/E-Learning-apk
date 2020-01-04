package com.example.android_e_learning;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.tauth.UiError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity implements QQLogInManager.QQLoginListener {

    Button signInButton;
    Button logInButton;
    TextView forget_password;
    private QQLogInManager qqLoginManager;
    ImageButton qqButton;
    ImageButton weiboButton;
    ImageButton wechatButton;

    EditText usernameView;
    EditText passwordView;

    MyReceiver dynamicReceiver  = new MyReceiver();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        final SharedPreferences sharedPreferences = getSharedPreferences("is_first_in_data", MODE_PRIVATE);
        final MySharedPreferences mySharedPreferences = MySharedPreferences.getSharedPreferences(sharedPreferences);
        mySharedPreferences.setIsFirstLogInOne();

        usernameView = (EditText) findViewById(R.id.username);
        passwordView = (EditText) findViewById(R.id.password);

        IntentFilter dynamic_filter = new IntentFilter();
        dynamic_filter.addAction("com.example.android_e_learning.myreceiver");
        registerReceiver(dynamicReceiver, dynamic_filter);

        signInButton = (Button) findViewById(R.id.sign_in);
        signInButton.setTextColor(Color.rgb(255, 255, 255));
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameView.getText().toString();
                String password = passwordView.getText().toString();
                Boolean exists = false;
                Boolean correctPass = false;

                if (username.equals("") || username.length() == 0) {
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                            .setIcon(R.drawable.ic_w)//设置标题的图片
                            .setTitle("Warning")//设置对话框的标题
                            .setMessage("The username can't be empty !")//设置对话框的内容
                            //设置对话框的按钮
                            .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                } else if (password.equals("") || password.length() == 0) {
                    AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                            .setIcon(R.drawable.ic_w)//设置标题的图片
                            .setTitle("Warning")//设置对话框的标题
                            .setMessage("The password can't be empty !")//设置对话框的内容
                            //设置对话框的按钮
                            .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                } else {
                    String usersJson = GetByURL.readParse("http://47.94.107.165:8080/elearn/customers");
                    try {
                        JSONArray users = new JSONArray(usersJson);

                        for (int i = 0; i < users.length(); i++) {
                            JSONObject user = users.getJSONObject(i);
                            String name = user.getString("username");
                            if (username.equals(name)) {
                                exists = true;
                                String pass = user.getString("password");
                                if (password.equals(pass)) {
                                    correctPass = true;
                                }
                                break;

                            }

                        }

                        if (exists) {
                            if (correctPass) {
                                mySharedPreferences.setIsFirstLogInTwo();
                                Intent intent = new Intent(MainActivity.this, ListCourseActivity.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
                                finish();
                            } else {
                                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                                        .setIcon(R.drawable.ic_w)//设置标题的图片
                                        .setTitle("Warning")//设置对话框的标题
                                        .setMessage("Your password is not correctly !")//设置对话框的内容
                                        //设置对话框的按钮
                                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        }).create();
                                dialog.show();
                            }

                        } else {
                            AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                                    .setIcon(R.drawable.ic_w)//设置标题的图片
                                    .setTitle("Warning")//设置对话框的标题
                                    .setMessage("The user does not exist !")//设置对话框的内容
                                    //设置对话框的按钮
                                    .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    }).create();
                            dialog.show();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        });

        logInButton = (Button) findViewById(R.id.log_in);
        logInButton.setTextColor(Color.rgb(255, 255, 255));
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
            }
        });

        forget_password = (TextView) findViewById(R.id.forgetpass);
        forget_password.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetPassActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
            }
        });

        qqLoginManager = new QQLogInManager("101838566", this);
        qqButton = findViewById(R.id.qq);
        qqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySharedPreferences.setIsFirstLogInTwo();
                qqLoginManager.launchQQLogin();
            }
        });

        weiboButton = (ImageButton) findViewById(R.id.weibo);
        weiboButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "This will be developed in " +
                        "the future !", Toast.LENGTH_SHORT).show();

            }
        });

        wechatButton = (ImageButton) findViewById(R.id.wechat);
        wechatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "This will be developed in " +
                        "the future !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // 回调
        super.onActivityResult(requestCode, resultCode, data);
        qqLoginManager.onActivityResultData(requestCode, resultCode, data);
    }

    @Override
    public void onQQLoginSuccess(JSONObject jsonObject, QQLogInManager.UserAuthInfo authInfo) {
        final SharedPreferences sharedPreferences = getSharedPreferences("is_first_in_data", MODE_PRIVATE);
        final MySharedPreferences mySharedPreferences = MySharedPreferences.getSharedPreferences(sharedPreferences);
        mySharedPreferences.setIsFirstLogInTwo();
        Intent intent = new Intent(MainActivity.this, ListCourseActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
        finish();
    }

    @Override
    public void onQQLoginCancel() {

    }

    @Override
    public void onQQLoginError(UiError uiError) {

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(dynamicReceiver);
        super.onDestroy();
    }
}
