package com.littlezheng.broadcast_localbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private LocalBroadcastManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = LocalBroadcastManager.getInstance(getBaseContext());

        //注册本地广播接收器
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.littlezheng.broadcast.MY_CUSTOM_BROADCAST");
        manager.registerReceiver(new CustomLocalBroadcastReceiver(),filter);

        findViewById(R.id.btn_send_local_broadcast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取一个本地广播管理对象，然后调用发送广播方法
                Intent intent =new Intent("com.littlezheng.broadcast.MY_CUSTOM_BROADCAST");
                intent.putExtra("custom_broadcast_msg","本地广播传递的数据");
                manager.sendBroadcast(intent);
            }
        });

    }
}
