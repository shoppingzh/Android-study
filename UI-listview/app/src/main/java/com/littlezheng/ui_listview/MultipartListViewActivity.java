package com.littlezheng.ui_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MultipartListViewActivity extends AppCompatActivity {

    private List<Contact> contactList;

    {
        contactList = new ArrayList<Contact>();
        for(int i=0;i<50;i++){
            Contact c = new Contact();
            c.setHeadImageId(R.drawable.head_2);
            c.setUsername("www.littlezheng.com"+(i+1));
            c.setOtherInfo("[离线请留言]个人博客http://www.littlezh...");
            contactList.add(c);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipart_list_view);

        ListView listView = (ListView) findViewById(R.id.multipart_list_view);
        listView.setAdapter(new ContactListAdapter(getBaseContext(),R.layout.list_view_item_qq_contact,contactList));

    }
}
