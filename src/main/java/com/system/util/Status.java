package com.system.util;

public enum Status {
    SUCCESS(200,"操作成功!"),
    ERROR(500,"操作失败!"),
    NO_AUTH(401,"没有权限!"),
    TOKEN_ERROR(402,"超时或不合法的token!")
    ;
    int code;

    String msg;

    Status() {
    }

    Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
