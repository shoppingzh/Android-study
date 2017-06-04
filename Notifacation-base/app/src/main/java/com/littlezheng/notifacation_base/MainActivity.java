package com.littlezheng.notifacation_base;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private NotificationManager notificationManager;
    private int count = 0;

    private Button toActivityBtn;
    private Button sendBroadcastBtn;
    private Button setSoundBtn;
    private Button vibrateBtn;
    private Button lightsBtn;
    private Button aboveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        toActivityBtn = (Button) findViewById(R.id.btn_notify);
        sendBroadcastBtn = (Button) findViewById(R.id.btn_send_broadcast);
        setSoundBtn = (Button) findViewById(R.id.btn_sound);
        vibrateBtn = (Button) findViewById(R.id.btn_vibrate);
        lightsBtn = (Button) findViewById(R.id.btn_lights);
        aboveBtn = (Button) findViewById(R.id.btn_above);

        toActivityBtn.setOnClickListener(this);
        sendBroadcastBtn.setOnClickListener(this);
        setSoundBtn.setOnClickListener(this);
        vibrateBtn.setOnClickListener(this);
        lightsBtn.setOnClickListener(this);
        aboveBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_notify:
                notifyNormal();
                break;
            case R.id.btn_send_broadcast:
                notifySendBroadcast();
                break;
            case R.id.btn_sound:
                notifyWithSound();
                break;
            case R.id.btn_vibrate:
                notifyWithVibrate();
                break;
            case R.id.btn_lights:
                notifyWithLights();
                break;
            case R.id.btn_above:
                notifyAbove();
                break;
        }
    }

    /**
     * 在最上方显示的通知
     */
    private void notifyAbove() {
        String contentText = "这是一个优先级最高的通知";
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("通知1")
                .setContentText(contentText)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .build();
        notificationManager.notify(++count,notification);
    }

    /**
     * 带有呼吸灯的通知
     */
    private void notifyWithLights() {
        String contentText = "这是一个带有呼吸灯效果的通知";
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("通知1")
                .setContentText(contentText)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                .setLights(Color.BLUE,1000,1000)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .build();
        notificationManager.notify(++count,notification);
    }

    /**
     * 带有振动效果的通知
     */
    private void notifyWithVibrate() {
        String contentText = "这是一个带有振动效果的通知";
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("通知1")
                .setContentText(contentText)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                .setVibrate(new long[]{0,1000,0,1000})
                .build();
        notificationManager.notify(++count,notification);
    }

    /**
     * 带有音效的通知
     */
    private void notifyWithSound() {
        String contentText = "这是一个带有音效的通知";
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("通知1")
                .setContentText(contentText)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
//                .setVibrate(new long[]{0,1000,0,1000})
                .build();
        notificationManager.notify(++count,notification);
    }

    /**
     * 可发送广播的通知
     */
    private void notifySendBroadcast() {
        String contentText = "这是一个可发送广播的通知";
        Intent intent = new Intent("com.littlezheng.broadcast.notification_broadcast");
        intent.putExtra("content",contentText);
        PendingIntent pi = PendingIntent.getBroadcast(getBaseContext(),0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("通知1")
                .setContentText(contentText)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                .setContentIntent(pi)
                .build();
        notificationManager.notify(++count,notification);
    }

    /**
     * 基础可点击通知
     */
    private void notifyNormal() {
        String contentText = "这是一个示例的最基础通知";
        Intent intent = new Intent(MainActivity.this,NotificationClickActivity.class);
        intent.putExtra("content",contentText);
        PendingIntent pi = PendingIntent.getActivity(getBaseContext(),0,intent,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("通知1")
                .setContentText(contentText)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round))
                .setContentIntent(pi)
                .build();
        notificationManager.notify(++count,notification);

    }

}
