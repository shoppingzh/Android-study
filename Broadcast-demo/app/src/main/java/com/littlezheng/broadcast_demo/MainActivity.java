package com.littlezheng.broadcast_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickListener = new MainOnClickListener();

        findViewById(R.id.btn_login).setOnClickListener(onClickListener);
    }

    /**
     * 登录
     */
    private void login(){
        Toast.makeText(getBaseContext(),"登录中..",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getBaseContext(),LoginResultActivity.class);
        startActivity(intent);
    }

    class MainOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int widgetId = v.getId();
            //注册事件
            switch (widgetId){
                case R.id.btn_login:
                    login();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 一旦在首页按下返回键，则销毁所有活动，退出应用
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG,"按下返回键");
        ActivitiesHolder.destroyAll();
        Log.d(TAG,"活动数："+ActivitiesHolder.getAcitivitySize());
    }
}
