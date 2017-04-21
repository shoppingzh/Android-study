package com.littlezheng.ui_listview;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zxp on 2017/4/17.
 */

public class ContactListAdapter extends ArrayAdapter<Contact> {

    private int resourceId;

    public ContactListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        //该步的作用是获取到列表项布局文件的id
        this.resourceId = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Contact contact = getItem(position);
        Log.d("适配器类","getView方法调用："+contact.getUsername());
        //试图拖慢该方法的运行速度
        /*for(int i=0;i<65535;i++){
            for(int j=0;j<100;j++);
        }*/
        //获取到列表项布局对象，convertView是缓存View对象，先从缓存中取，如果没有，则获取
        View view = null;
        if(convertView != null){
            view =convertView;
        }else{
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }

        //通过布局对象获取布局下的控件
        ImageView headImageView = (ImageView) view.findViewById(R.id.contact_head_image);
        TextView usernameText = (TextView) view.findViewById(R.id.contact_username);
        TextView otherInfoText = (TextView) view.findViewById(R.id.contact_other_info);

        //为控件设定一定的样式或事件
        headImageView.setImageResource(contact.getHeadImageId());
        usernameText.setText(contact.getUsername());
        otherInfoText.setText(contact.getOtherInfo());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"您当前点击的用户是："+contact.getUsername(),Toast.LENGTH_SHORT)
                        .show();
            }
        });
        return view;
    }

}
