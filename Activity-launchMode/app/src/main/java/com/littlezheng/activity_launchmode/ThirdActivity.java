package com.littlezheng.activity_launchmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Log.d(TAG,"第三个活动"+this.toString());
        Log.d(TAG,"第三个活动位于的返回栈ID："+getTaskId());
    }
}
