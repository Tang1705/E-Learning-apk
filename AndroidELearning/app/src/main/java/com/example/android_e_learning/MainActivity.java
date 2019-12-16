package com.example.android_e_learning;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;


@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity {

    Button signInButton;
    Button logInButton;
    TextView forget_password;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        signInButton = (Button) findViewById(R.id.sign_in);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListCourseActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
                finish();

            }
        });

        logInButton = (Button) findViewById(R.id.log_in);
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
    }


}
