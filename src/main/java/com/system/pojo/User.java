package com.system.pojo;


import com.system.util.Page;

import java.io.Serializable;

public class User extends Page{

    int uid;

    String uname;

    String password;

    int type;

    public User() {
    }

    public User(int uid, String uname, String password, int type) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
