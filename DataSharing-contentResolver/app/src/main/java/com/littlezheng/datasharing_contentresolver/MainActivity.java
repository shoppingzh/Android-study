package com.littlezheng.datasharing_contentresolver;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int READ_CONTACTS_REQUEST_CODE = 1;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_read_contacts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(getBaseContext(),Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(getBaseContext(),"您还没有读取联系人权限！",Toast.LENGTH_SHORT).show();
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_CONTACTS},READ_CONTACTS_REQUEST_CODE);
                }else{
                    readContacts();
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case READ_CONTACTS_REQUEST_CODE :
                if(permissions.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //权限申请成功
                    readContacts();
                }else{
                    Toast.makeText(getBaseContext(),"您拒绝了该权限！",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 读取手机联系人
     */
    private void readContacts() {
        ContentResolver resolver = getContentResolver();
        Cursor cursor =
                resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);

        List<Contact> contacts = null;
        if(cursor != null){
            contacts = new ArrayList<Contact>();
            while(cursor.moveToNext()){
                //获取姓名
                String displayName =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNum =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Contact c = new Contact(displayName,phoneNum);
                contacts.add(c);
                Log.d(TAG,"姓名："+displayName+"，电话号码："+phoneNum);
            }
        }

        //跳转到显示页面
        Intent intent = new Intent(MainActivity.this,ContactsShowActivity.class);
        intent.putParcelableArrayListExtra("contacts", (ArrayList<? extends Parcelable>) contacts);
        startActivity(intent);

    }

}
