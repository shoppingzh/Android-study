package com.littlezheng.persistent_litepal;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.littlezheng.persistent_litepal.pojo.User;

import java.util.List;

/**
 * Created by zxp on 2017/4/23.
 */

public class UserAdapter extends ArrayAdapter<User>{

    private int resouceId;
    private List<User> userList;


    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<User> userList) {
        super(context, resource, userList);
        this.resouceId = resource;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
        final User user = getItem(position);
        final View view = LayoutInflater.from(getContext()).inflate(resouceId,parent,false);

        TextView idText = (TextView) view.findViewById(R.id.text_id);
        TextView nameText = (TextView) view.findViewById(R.id.text_name);
        TextView ageText = (TextView) view.findViewById(R.id.text_age);

        view.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.delete();
//                userList.remove(user);
                remove(user);
//                notifyDataSetChanged();
                Toast.makeText(parent.getContext(),"删除成功",Toast.LENGTH_SHORT).show();
            }
        });

        idText.setText(user.getId().toString());
        nameText.setText(user.getName());
        ageText.setText(user.getAge().toString());

        return view;
    }
}
