package com.littlezheng.persistent_litepal;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.littlezheng.persistent_litepal.pojo.User;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button saveBtn;
    private Button showAllBtn;
    private EditText nameEdit;
    private EditText ageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

        saveBtn = (Button) findViewById(R.id.btn_save);
        showAllBtn = (Button) findViewById(R.id.btn_show_all);
        nameEdit = (EditText) findViewById(R.id.edit_name);
        ageEdit = (EditText) findViewById(R.id.edit_age);

        //创建数据库
        findViewById(R.id.btn_create_db).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = Connector.getDatabase();
            }
        });

        //添加信息
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdit.getText().toString();
                int age;

                User user = new User();
                user.setName(name);

                try{
                    age = Integer.parseInt(ageEdit.getText().toString());
                    user.setAge(age);
                    user.save();
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"添加失败！"+e,Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getBaseContext(),"添加成功！",Toast.LENGTH_SHORT).show();
            }
        });

        //查看所有数据
        showAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> userList = DataSupport.findAll(User.class);
                if(userList == null || userList.isEmpty()){
                    Toast.makeText(MainActivity.this,"没有记录！",Toast.LENGTH_SHORT).show();
                    return;
                }
                ListView userListView = (ListView) findViewById(R.id.list_all_data);
                userListView.setAdapter(new UserAdapter(getBaseContext(),R.layout.listview_item_user,userList));
            }
        });

    }
}
