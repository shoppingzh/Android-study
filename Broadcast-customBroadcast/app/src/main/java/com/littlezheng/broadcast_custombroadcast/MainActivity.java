package com.littlezheng.broadcast_custombroadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver customBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customBroadcastReceiver = new CustomBroadcastReceiver();

        findViewById(R.id.btn_register_receiver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerReceiver();
                Toast.makeText(getBaseContext(),"成功注册广播接收器，现在可以发送自定义广播了！",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_unregister_receiver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unregisterReceiver();
                Toast.makeText(getBaseContext(),"广播接收器已注销！",Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_send_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast();
            }
        });

    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.littlezheng.broadcast.MY_CUSTOM_BROADCAST");
        registerReceiver(customBroadcastReceiver,filter);
    }

    private void unregisterReceiver(){
        unregisterReceiver(customBroadcastReceiver);
    }

    private void sendBroadcast(){
        //发送一个自定义的广播
        //注意：发是发出去了，但是可能无法被接收到，所以需要创建广播接收器
        Intent intent = new Intent("com.littlezheng.broadcast.MY_CUSTOM_BROADCAST");
        intent.putExtra("custom_broadcast_msg","这是一个自定义广播携带的消息！");
        sendBroadcast(intent);
    }
}
