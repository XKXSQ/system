package com.system.util;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

public class Result {

    int code;

    String msg;

    Object data;

    //专门用于分页的方法
    public static Map<String,Object> ok(PageInfo pageInfo){
        Map<String,Object> map = new HashMap<>();
        map.put("code",Status.SUCCESS.getCode());
        map.put("msg",Status.SUCCESS.getMsg());
        map.put("total",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    //操作成功并需要展示接收数据
    public static Result ok(Object data){
        return new Result(Status.SUCCESS.getCode(),Status.SUCCESS.getMsg(),data);
    }

    //操作成功但不需要展示接收数据
    public static Result ok(){
        return new Result(Status.SUCCESS.getCode(),Status.SUCCESS.getMsg(),null);
    }

    //操作失败且并不需要展示其他信息
    public static Result error(){
        return new Result(Status.ERROR.getCode(),Status.ERROR.getMsg(),null);
    }

    //操作失败并提示相关信息
    public static Result error(String msg){
        return new Result(Status.ERROR.getCode(),msg,null);
    }

    //没有操作权限
    public static Result no_auth(){
        return new Result(Status.NO_AUTH.getCode(),Status.NO_AUTH.getMsg(),null);
    }

    //token不合法
    public static Result fail(){ return new Result(Status.TOKEN_ERROR.getCode(),Status.TOKEN_ERROR.getMsg(),null); }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
