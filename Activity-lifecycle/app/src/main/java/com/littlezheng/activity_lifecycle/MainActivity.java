package com.littlezheng.activity_lifecycle;

import android.app.Dialog;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button startNormal;
    private Button startDialog;

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString("important_text","这是非常重要的信息");
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = (TextView)findViewById(R.id.main_text);
        if(savedInstanceState != null){
            textView.setText(savedInstanceState.getString("important_text"));
        }
        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);

        startNormal = (Button) findViewById(R.id.start_normal);
        startDialog = (Button) findViewById(R.id.start_dialog);

        startNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent normalIntent = new Intent();
                normalIntent.setClass(getBaseContext(),NormalActivity.class);
                startActivity(normalIntent);
            }
        });

        startDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialogIntent = new Intent();
                dialogIntent.setClass(getBaseContext(), DialogActivity.class);
                startActivity(dialogIntent);
            }
        });

    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG,"onRestart");
        super.onRestart();
    }

}
