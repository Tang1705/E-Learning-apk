package com.example.android_e_learning;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ForgetPassActivity extends AppCompatActivity {
    Button confirmButton;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        confirmButton = (Button) findViewById(R.id.confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = new AlertDialog.Builder(ForgetPassActivity.this)
                        .setIcon(R.drawable.ic_c)//设置标题的图片
                        .setTitle("Information")//设置对话框的标题
                        .setMessage("You have set a new password.")//设置对话框的内容
                        //设置对话框的按钮
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(ForgetPassActivity.this, MainActivity.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.out_alpha, R.anim.enter_alpha);
                                finish();
                            }
                        }).create();
                dialog.show();

            }
        });


    }

}
