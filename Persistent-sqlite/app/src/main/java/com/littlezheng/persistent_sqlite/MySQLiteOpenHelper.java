package com.littlezheng.persistent_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by zxp on 2017/4/20.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private Context context;

    public MySQLiteOpenHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuffer sb = new StringBuffer("create table user(");
        sb.append("id integer primary key autoincrement,");
        sb.append("name text not null,");
        sb.append("age integer,");
        sb.append("description text");
        sb.append(");");

        db.execSQL(sb.toString());
        Toast.makeText(context,"创建数据库成功！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(context,"更新数据库！",Toast.LENGTH_SHORT).show();
    }
}
