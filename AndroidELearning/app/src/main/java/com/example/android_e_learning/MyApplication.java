package com.example.android_e_learning;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

@SuppressLint("Registered")
public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context context; //全局的上下文

    /**
     * 在onCreate给全局上下文赋值,其生命周期跟随应用的生命周期一样长********************************
     */
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    /**
     * 提供一个获取全局上下文的方法,任何地方都可以获取到上下文,一劳永逸*****************************
     */
    public static Context getContext() {
        return context;
    }
}



