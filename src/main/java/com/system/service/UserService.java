package com.system.service;

import com.system.pojo.User;

import java.util.List;

public interface UserService {

    int createUser(User user);

    int deleteUser(int uid);

    int updateUser(User user);

    int updateUserSelective(User user);

    List<User> getAllUser();

    User getUserById(int uid);

    int batchDelete(String ids);

    User getLoginUser(String uname,String password);
}
