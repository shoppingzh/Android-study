package com.littlezheng.datasharing_contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by zxp on 2017/5/4.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private Context mContext;
    private static StringBuffer sqlSb;

    static{
        sqlSb = new StringBuffer("create table user(");
        sqlSb.append("id integer primary key autoincrement,");
        sqlSb.append("name text,");
        sqlSb.append("phone_num text);");
    }

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlSb.toString());
        Toast.makeText(mContext,"数据库创建成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
