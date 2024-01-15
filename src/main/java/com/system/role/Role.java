package com.system.role;

public enum Role {

    ADMIN(0,"ADMIN"),
    STUDENT(1,"STUDENT")
    ;

    private int code;

    private String type;


    Role() {
    }

    Role(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
