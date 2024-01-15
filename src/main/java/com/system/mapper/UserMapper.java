package com.system.mapper;

import com.system.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

//    @Select("select * from tb_user")
    List<User> getAllUser();

    @Select("select * from tb_user where uid = #{uid}")
    User getUserById(@Param("uid") int uid);

    int createUser(User user);

    int deleteUser(int uid);

    int updateUser(User user);

    int updateUserSelective(User user);

    //这里之所以使用@Param标签才能运行成功，是因为这里方法中使用了多参数
    User getLoginUser(@Param("uname") String uname, @Param("password") String password);
}
