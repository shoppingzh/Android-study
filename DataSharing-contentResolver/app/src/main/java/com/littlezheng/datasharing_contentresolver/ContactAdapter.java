package com.littlezheng.datasharing_contentresolver;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zxp on 2017/4/27.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    private int resource;
    private Context context;

    public ContactAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contact c = getItem(position);

        View view = null;
        TextView nameText = null;
        TextView numberText = null;
        if(convertView != null){
            view = convertView;
            ViewHolder holder = (ViewHolder) view.getTag();
            nameText = holder.nameText;
            numberText = holder.numberText;
        }else{
            view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
            nameText = (TextView) view.findViewById(R.id.text_contact_name);
            numberText = (TextView) view.findViewById(R.id.text_contact_number);
            ViewHolder holder = new ViewHolder(nameText,numberText);
            view.setTag(holder);
        }

        nameText.setText(c.getName());
        numberText.setText(c.getNumber());

        return view;
    }

    class ViewHolder{
        TextView nameText;
        TextView numberText;

        public ViewHolder(TextView nameText,TextView numberText){
            this.nameText = nameText;
            this.numberText = numberText;
        }
    }
}
