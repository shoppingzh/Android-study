package com.littlezheng.activity_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(),SecondActivity.class);
                //给下一个活动传递数据
                intent.putExtra("someText","这是上一个活动传递的数据!");
                //不再调用该方法，该方法不支持从下一个活动返回结果
                /*startActivity(intent);*/

                //该方法支持从下一个活动返回结果
                startActivityForResult(intent,1);
            }
        });
    }

    /**
     * 该方法感知下一个活动的结束并返回结果
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                TextView textView = (TextView) findViewById(R.id.first_text1);
                textView.setText(data.getStringExtra("finished_text"));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
