package com.littlezheng.ui_listview;

/**
 * Created by zxp on 2017/4/17.
 */

public class Contact {

    private int headImageId;
    private String username;
    private String otherInfo;

    public int getHeadImageId() {
        return headImageId;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public String getUsername() {
        return username;
    }

    public void setHeadImageId(int headImageId) {
        this.headImageId = headImageId;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
