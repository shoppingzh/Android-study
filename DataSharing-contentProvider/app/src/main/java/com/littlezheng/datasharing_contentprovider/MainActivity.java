package com.littlezheng.datasharing_contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ContentResolver resolver;

    private Button showDataBtn;
    private EditText nameEdit;
    private EditText phoneNumEdit;
    private Button addBtn;
    private TextView dataText;

    private static final String URI = "content://com.littlezheng.provider/user";
    private static final Uri uri = Uri.parse(URI);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resolver = getContentResolver();

        showDataBtn = (Button) findViewById(R.id.btn_show_data);
        nameEdit = (EditText) findViewById(R.id.edit_name);
        phoneNumEdit = (EditText) findViewById(R.id.edit_phone_num);
        addBtn = (Button) findViewById(R.id.btn_add);
        dataText = (TextView) findViewById(R.id.text_data);

        showDataBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_show_data:
                showAllData();
                break;
            case R.id.btn_add:
                addData();
                break;
        }
    }

    /**
     * 添加数据
     */
    private void addData() {
        String name = nameEdit.getText().toString();
        String phoneNum = phoneNumEdit.getText().toString();
        ContentValues cvs = new ContentValues();
        cvs.put("name",name);
        cvs.put("phone_num",phoneNum);
        resolver.insert(uri,cvs);
        Toast.makeText(getBaseContext(),"添加数据成功！",Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示所有数据
     */
    private void showAllData() {
        Cursor c = resolver.query(uri,null,null,null,null);
        dataText.setText("");
        while(c.moveToNext()){
            String name = c.getString(c.getColumnIndex("name"));
            String phoneNum = c.getString(c.getColumnIndex("phone_num"));
            String datas = dataText.getText().toString();
            datas = datas + "\n姓名：" + name + "，\n手机号码："+phoneNum;
            dataText.setText(datas);
        }
    }

}
