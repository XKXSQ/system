package com.system.util;

public class UserThreadLocal {

    public static ThreadLocal<String> userThreadLocal = new ThreadLocal<>();

    public static void set(String token){
        userThreadLocal.set(token);
    }

    public static String get(){
        String token = userThreadLocal.get();
        return token;
    }

    public static void remove(){
        userThreadLocal.remove();
    }
}
