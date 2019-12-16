package com.example.android_e_learning;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetByURL {
    @SuppressLint("ObsoleteSdkInt")
    public static String readParse(String urlPath) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        URL url;
        try {
            url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            InputStream inStream = conn.getInputStream();
            while ((len = inStream.read(data)) != -1) {
                outStream.write(data, 0, len);
            }
            inStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String a = new String(outStream.toByteArray());//通过out.Stream.toByteArray获取到写的数据
        return a;
    }
}
