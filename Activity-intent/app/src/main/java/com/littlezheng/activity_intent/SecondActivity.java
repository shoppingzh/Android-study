package com.littlezheng.activity_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button2 = (Button) findViewById(R.id.button2);
        Button finish2 = (Button) findViewById(R.id.finish2);

        //接受来自上一个活动传入的数据
        Intent intent = getIntent();
        String info = intent.getStringExtra("someText");
        button2.setText(info);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示intent，通过当前上下文对象和要跳转活动的类对象进行跳转
                /*Intent intent = new Intent();
                intent.setClass(getBaseContext(),ThirdActivity.class);
                startActivity(intent);*/
                Intent intent2 = new Intent("com.littlezheng.activity.ACTION_START");
                startActivity(intent2);
            }
        });

        //结束活动并返回数据给上一个活动
        finish2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });
    }

    private void sendData(){
        Intent intent2 = new Intent();
        intent2.putExtra("finished_text","上一个活动结束后传递的数据");
        setResult(RESULT_OK,intent2);
        finish();
    }

    @Override
    public void onBackPressed() {
        sendData();
        super.onBackPressed();
    }

}
