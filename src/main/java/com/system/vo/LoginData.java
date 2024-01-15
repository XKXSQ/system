package com.system.vo;

public class LoginData {

    int uid;
    String uname;
    String password;
    int type;
    String token;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public LoginData() {
    }

    public LoginData(int uid, String uname, String password, int type, String token) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.type = type;
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
