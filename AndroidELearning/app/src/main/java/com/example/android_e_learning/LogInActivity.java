package com.example.android_e_learning;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends AppCompatActivity {
    Button confirmButton;
    EditText usernameView;
    EditText passwordView;
    EditText confirmPasswordView;
    EditText emailView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        usernameView = (EditText) findViewById(R.id.username);
        passwordView = (EditText) findViewById(R.id.password);
        confirmPasswordView = (EditText) findViewById(R.id.confirmpass);
        emailView = (EditText) findViewById(R.id.email);

        confirmButton = (Button) findViewById(R.id.confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameView.getText().toString();
                String password = passwordView.getText().toString();
                String confirmPass = confirmPasswordView.getText().toString();
                String email = emailView.getText().toString();

                if (username.equals("") || username.length() == 0) {
                    AlertDialog dialog = new AlertDialog.Builder(LogInActivity.this)
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
                    AlertDialog dialog = new AlertDialog.Builder(LogInActivity.this)
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
                } else if (confirmPass.equals("") || confirmPass.length() == 0) {
                    AlertDialog dialog = new AlertDialog.Builder(LogInActivity.this)
                            .setIcon(R.drawable.ic_w)//设置标题的图片
                            .setTitle("Warning")//设置对话框的标题
                            .setMessage("The confirm password can't be empty !")//设置对话框的内容
                            //设置对话框的按钮
                            .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                } else if (email.equals("") || email.length() == 0) {
                    AlertDialog dialog = new AlertDialog.Builder(LogInActivity.this)
                            .setIcon(R.drawable.ic_w)//设置标题的图片
                            .setTitle("Warning")//设置对话框的标题
                            .setMessage("The email address can't be empty !")//设置对话框的内容
                            //设置对话框的按钮
                            .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                } else if (!password.equals(confirmPass)) {
                    AlertDialog dialog = new AlertDialog.Builder(LogInActivity.this)
                            .setIcon(R.drawable.ic_w)//设置标题的图片
                            .setTitle("Warning")//设置对话框的标题
                            .setMessage("The two passwords are different, please try again !")//设置对话框的内容
                            //设置对话框的按钮
                            .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                } else {
                    String result = GetByURL.readParse("http:tang5618.com:8080/elearn/" + username + "," + password + "," + email + ",");

                    if (result.equals("1")) {
                        AlertDialog dialog = new AlertDialog.Builder(LogInActivity.this)
                                .setIcon(R.drawable.ic_c)//设置标题的图片
                                .setTitle("Congratulations")//设置对话框的标题
                                .setMessage("You have registered successfully!")//设置对话框的内容
                                //设置对话框的按钮
                                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
                                        finish();
                                    }
                                }).create();
                        dialog.show();
                    } else {
                        AlertDialog dialog = new AlertDialog.Builder(LogInActivity.this)
                                .setIcon(R.drawable.ic_w)//设置标题的图片
                                .setTitle("Warning")//设置对话框的标题
                                .setMessage("The username has already existed, please try again !")//设置对话框的内容
                                //设置对话框的按钮
                                .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).create();
                        dialog.show();
                    }
                }
            }
        });


    }


    protected void onPause() {
        // TODO Auto-generated method stub

        super.onPause();

        overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);

    }

}
