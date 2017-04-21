package com.littlezheng.activity_launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button toMyself;
    private Button toSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toMyself = (Button) findViewById(R.id.to_myself);
        toSecond = (Button)findViewById(R.id.to_second);

        Log.d(TAG,"第一个活动"+this.toString());
        Log.d(TAG,"第一个活动位于的返回栈ID："+getTaskId());

        toMyself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,MainActivity.this.toString());
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        toSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,this.toString());
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"第一个活动被销毁");
        super.onDestroy();
    }

}
