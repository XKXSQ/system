package com.system.controller;

import com.system.config.redis.RedisUtil;
import com.system.pojo.User;
import com.system.role.RequiresRoles;
import com.system.role.Role;
import com.system.service.UserService;
import com.system.util.Result;
import com.system.vo.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

//用于登录
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> map){
        String uname = map.get("uname");
        String password = map.get("password");
        String type = map.get("type");

        boolean flag = false;
        LoginData loginUser = new LoginData();

        User user = userService.getLoginUser(uname,password);

        if(user!= null){
            loginUser.setUid(user.getUid());
            loginUser.setUname(user.getUname());
            loginUser.setPassword(user.getPassword());
            loginUser.setType(user.getType());
            flag = true;
        }

        if(flag){
            String token = UUID.randomUUID().toString();
            loginUser.setToken(token);
            redisUtil.set(token,loginUser,RedisUtil.EXPR);
            return Result.ok(loginUser);
        }else {
            return Result.error("用户名或密码错误！");
        }

    }

}
