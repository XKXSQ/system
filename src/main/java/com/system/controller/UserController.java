package com.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.system.pojo.User;
import com.system.service.UserService;
import com.system.util.Page;
import com.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//处理用户
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    Page page = new Page(1,5);

    //新增用户
    @PostMapping("create")
    public Result createUser(@RequestBody User user){
        int row = userService.createUser(user);
        if(row > 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    //删除用户(单个)
    @DeleteMapping("delete")
    public Result deleteUser(int uid){
        int row = userService.deleteUser(uid);
        if(row > 0){
            return Result.ok();
        }else{
            return Result.error();
        }
    }

    //批量删除
    @DeleteMapping("batchDelete")
    public Result batchDelete(String ids){
        int row = userService.batchDelete(ids);
        if(row > 0){
            return Result.ok(row);
        }else {
            return Result.error();
        }
    }

    //修改用户
    @PutMapping("update")
    public Result updataUser(@RequestBody User user){
        int row = userService.updateUserSelective(user);
        if(row > 0){
            return Result.ok();
        }else {
            return Result.error();
        }
    }

    //根据id获取用户信息
    @GetMapping("getById")
    public Result getUseById(int uid){
        User user = userService.getUserById(uid);
        if(user!=null){
            return Result.ok(user);
        }else {
            return Result.error();
        }
    }

    //获取所有用户信息
    @GetMapping("getAll")
    public Result getAllUser(){
        List<User> list = userService.getAllUser();
        if(list!=null){
            return Result.ok(list);
        }else {
            return Result.error();
        }
    }

    //分页
    @GetMapping("page")
    public Map<String, Object> getUserPage(@RequestBody User user){
        PageHelper.startPage(user.getPageNum(),user.getPageSize());
        //这里有一个很重要的点，就是调用了PageHelper中的startPage方法之后，
        //分页工具会自动将调用了这个方法的后面的第一条查询语句拿来做分页处理
        List<User> userList = userService.getAllUser();
        //这里userList会被分页工具自动用来进行分页处理
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        //然后再用pageInfo来存储分页信息
        return Result.ok(pageInfo);
    }


//    @GetMapping("/{uid}")
//    public User getUserById(@PathVariable("uid") int uid){
//        return userService.getUserById(uid);
//    }
}
