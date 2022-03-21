package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendNoti = findViewById(R.id.btnNoti);
        btnSendNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();
            }
        });
    }
    public void sendNotification(){
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        Notification notification=new Notification.Builder(this)
                .setContentTitle("Title Push notifications")
                .setContentText("Message Push Notifications")
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setLargeIcon(bitmap)
                .build();

        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if(notificationManager!= null){
            Random notification_id = new Random();
            notificationManager.notify(notification_id.nextInt(100),notification);
        }
    }
    private int getNotificationId(){
        return (int) new Date().getTime();
    }
}