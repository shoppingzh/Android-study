package com.littlezheng.datasharing_contentresolver;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ContactsShowActivity extends AppCompatActivity {

    private ListView contactListView;
    private  List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);
        contactListView = (ListView) findViewById(R.id.list_contacts);

        Intent intent = getIntent();

        if(intent != null){
            contacts = intent.getParcelableArrayListExtra("contacts");
            contactListView.setAdapter(new ContactAdapter(getBaseContext(),
                    R.layout.list_item_contact,contacts));
            contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Contact c = contacts.get(position);
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+c.getNumber()));
                    startActivity(intent);
                }
            });
        }
    }
}
