package com.system.service.impl;

import com.system.mapper.UserMapper;
import com.system.pojo.User;
import com.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }

    @Override
    public int deleteUser(int uid) {
        return userMapper.deleteUser(uid);
    }


    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserSelective(User user) {
        return userMapper.updateUserSelective(user);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(int uid) {
        return userMapper.getUserById(uid);
    }

    @Override
    public int batchDelete(String ids) {
        int row = 0;
        String[] str = ids.split(",");
        for(String s:str){
            if(StringUtils.hasText(s)){
                userMapper.deleteUser(Integer.parseInt(s));
                row++;
            }else{
                continue;
            }
        }
        return row;
    }

    @Override
    public User getLoginUser(String uname, String password) {
        return userMapper.getLoginUser(uname,password);
    }


}
