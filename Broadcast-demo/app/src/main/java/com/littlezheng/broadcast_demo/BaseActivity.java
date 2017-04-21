package com.littlezheng.broadcast_demo;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    private final BroadcastReceiver forceOfflineBroadcastReceiver
            = new ForceOfflineBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitiesHolder.add(this);
        Log.d(this.toString(),"活动数："+ActivitiesHolder.getAcitivitySize());

        //为所有继承该基础活动的活动类注册一个强制下线的广播接收器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.littlezheng.broadcast.FORCE_OFF_LINE");
        registerReceiver(forceOfflineBroadcastReceiver,intentFilter);
        Toast.makeText(getBaseContext(),"强制下线广播接收器注册成功！",Toast.LENGTH_SHORT).show();
    }


    /**
     * 注意每个活动销毁时，都应注销广播接收器
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(forceOfflineBroadcastReceiver);
    }
}
