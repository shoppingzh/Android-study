package com.littlezheng.persistent_litepal.pojo;

import org.litepal.crud.DataSupport;

/**
 * Created by zxp on 2017/4/22.
 */

public class User extends DataSupport{

    private Integer id;
    private String name;
    private Integer age;

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
