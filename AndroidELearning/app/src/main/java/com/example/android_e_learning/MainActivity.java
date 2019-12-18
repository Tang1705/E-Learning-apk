package com.example.android_e_learning;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.tencent.tauth.UiError;

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

        signInButton = (Button) findViewById(R.id.sign_in);
        signInButton.setTextColor(Color.rgb(255, 255, 255));
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySharedPreferences.setIsFirstLogInTwo();
                Intent intent = new Intent(MainActivity.this, ListCourseActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
                finish();

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
                finish();
            }
        });

        forget_password = (TextView) findViewById(R.id.forgetpass);
        forget_password.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetPassActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
                finish();
            }
        });

        qqLoginManager = new QQLogInManager("app_id", this);
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

    }

    @Override
    public void onQQLoginCancel() {

    }

    @Override
    public void onQQLoginError(UiError uiError) {

    }
}
