package com.example.android_e_learning;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;


public class MyReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        System.out.println("---------------接收动态广播");
        if (intent.getAction().equals("com.example.android_e_learning.myreceiver")) {
            System.out.println("进来了");

            String id = "channel_001";
            String name = "name";
            NotificationManager notificationManager = (NotificationManager)
                    context.getSystemService(Context.NOTIFICATION_SERVICE);

            Notification notification = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {//判断API
                NotificationChannel mChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_LOW);
                assert notificationManager != null;
                notificationManager.createNotificationChannel(mChannel);
                notification = new Notification.Builder(context,id)
                        .setChannelId(id)
                        .setContentTitle("Notification")
                        .setContentText("There are some new courses in the server!")
                        .setSmallIcon(R.drawable.ic_icon_fingerprint).build();
            }else{
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context,id)
                        .setContentTitle("Notification")
                        .setContentText("There are some new courses in the server!")
                        .setSmallIcon(R.drawable.ic_icon_fingerprint)
                        .setOngoing(true)
                        .setChannelId(id);//无效
                notification = notificationBuilder.build();
            }

            notificationManager.notify(1,notification);
        }
    }
}
