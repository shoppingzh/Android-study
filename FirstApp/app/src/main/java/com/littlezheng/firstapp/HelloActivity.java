package com.littlezheng.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.littlezheng.firstapp.R.*;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.hello_layout);
    }

    /**
     * 创建活动的同时初始化选项菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 菜单项选中事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId){
            case R.id.add:
                toastText("添加");
                break;
            case R.id.remove:
                toastText("删除");
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * 弹出信息
     * @param text
     */
    private void toastText(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT)
                .show();
    }
}
