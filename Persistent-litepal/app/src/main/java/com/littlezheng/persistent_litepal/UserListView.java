package com.littlezheng.persistent_litepal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ListView;

/**
 * Created by zxp on 2017/4/23.
 */

public class UserListView extends ListView {

    public UserListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //加载该布局
        LayoutInflater.from(context).inflate(R.layout.listview_item_user,this);
    }



}
