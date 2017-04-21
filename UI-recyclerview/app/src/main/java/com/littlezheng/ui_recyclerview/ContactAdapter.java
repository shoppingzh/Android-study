package com.littlezheng.ui_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zxp on 2017/4/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Contact> contactList;

    public ContactAdapter(List<Contact> contactList){
        this.contactList = contactList;
    }

    //该类用来缓存view中的控件对象
    static class ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView headImageView;
        TextView usernameTextView;
        TextView otherInfoTextView;

        public ContactViewHolder(View itemView) {
            super(itemView);
            this.headImageView = (ImageView) itemView.findViewById(R.id.contact_head_image);
            this.usernameTextView = (TextView) itemView.findViewById(R.id.contact_username);
            this.otherInfoTextView = (TextView) itemView.findViewById(R.id.contact_other_info);
        }
    }


    /**
     * 该方法当ViewHolder对象被创建前调用，因为ViewHolder对象缓存了布局中的控件，所以，在该方法中
     * 获取布局，并实例化一个ViewHolder对象返回
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recycler_view_item_qq_contact,parent,false);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    /**
     * 该方法在绑定ViewHolder对象时调用，其目的是获取集合对象中的元素，然后通过ViewHolder对象获取
     * 控件，再为每个控件设定一定的内容或事件
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Contact c = contactList.get(position);
        ContactViewHolder contactViewHolder = (ContactViewHolder) holder;
        contactViewHolder.headImageView.setImageResource(c.getHeadImageId());
        contactViewHolder.usernameTextView.setText(c.getUsername());
        contactViewHolder.otherInfoTextView.setText(c.getOtherInfo());
    }


    /**
     * 获取列表项数量
     * @return
     */
    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
