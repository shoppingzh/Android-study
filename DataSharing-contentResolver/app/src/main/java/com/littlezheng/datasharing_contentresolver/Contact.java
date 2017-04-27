package com.littlezheng.datasharing_contentresolver;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zxp on 2017/4/27.
 */

public class Contact implements Parcelable {

    private String name;
    private String number;

    public Contact(){}

    public Contact(String name,String number){
        this.name = name;
        this.number = number;
    }

    protected Contact(Parcel in) {
        name = in.readString();
        number = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(number);
    }
}
