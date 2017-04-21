package com.littlezheng.ui_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contact> contactList;

    {
        contactList = new ArrayList<>();
        for(int i=0;i<100;i++){
            Contact c = new Contact();
            c.setHeadImageId(R.drawable.head_2);
            c.setUsername("郑晓平"+(i+1));
            c.setOtherInfo("[离线请留言]个人博客：http://www.littlezh...");
            contactList.add(c);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","联系人数据："+contactList);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //因为RecyclerView控件即支持纵向滑动，还支持横向滑动等，因此需要传入给该控件一个布局形式
        LinearLayoutManager layoutManager =  new LinearLayoutManager(this);
        //设置为横向布局，则所有列表项横向摆放
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ContactAdapter(contactList));

    }
}
