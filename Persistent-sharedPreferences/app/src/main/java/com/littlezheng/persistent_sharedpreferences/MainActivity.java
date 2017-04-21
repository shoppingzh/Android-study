package com.littlezheng.persistent_sharedpreferences;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.gesture.Prediction;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText usernameEdit;
    private EditText passwordEdit;
    private CheckBox rememberUserPassCheckBox;

    private SharedPreferences userPassPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEdit = (EditText) findViewById(R.id.input_user_name);
        passwordEdit = (EditText) findViewById(R.id.input_password);
        rememberUserPassCheckBox = (CheckBox) findViewById(R.id.checkbox_remember_user_pass);

        //创建时，将用户记住的用户名和密码显示在页面
        userPassPref = getSharedPreferences("userPass",MODE_PRIVATE);
        usernameEdit.setText(userPassPref.getString("username",""));
        passwordEdit.setText(userPassPref.getString("password",""));
        rememberUserPassCheckBox.setChecked(true);

        //点击登录
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString();
                boolean loginRes = login(username, passwordEdit.getText().toString(),rememberUserPassCheckBox.isChecked());
                if(loginRes){
                    Intent intent = new Intent(getBaseContext(),LoginResultActivity.class);
                    intent.putExtra("username",username);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param remembered
     */
    private boolean login(String username, String password, boolean remembered) {
        Log.d(TAG,"用户名："+username+"，密码："+password);
        if(!checkForm(username,password)){
            //弹出提示信息
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("提示");
            alertDialog.setMessage("请完整填写用户名和密码！");
            alertDialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
            return false;
        }

        //表单填写正确，判断用户是否要求记住密码
        SharedPreferences.Editor editor = userPassPref.edit();
        if(remembered){
            editor.putString("username",username);
            editor.putString("password",password);
            editor.apply();
        }else{
            //如果用户不要求记住密码，则将以前的用户名密码信息也删去
            editor.remove("username").remove("password");
            editor.apply();
        }

        return true;
    }

    /**
     * 检测表单是否填写完整
     * @param username
     * @param password
     * @return
     */
    private boolean checkForm(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            return false;
        }
        return true;
    }

}
