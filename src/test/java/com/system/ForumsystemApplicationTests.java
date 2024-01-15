package com.system;

import com.system.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ForumsystemApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        redisTemplate.opsForValue().set("name","zhangsan");
        System.out.println(redisTemplate.opsForValue().get("name"));

        User user = new User();
        user.setUid(1);
        user.setUname("lisi");
        user.setPassword("123456");
        redisTemplate.opsForValue().set("user",user);

        System.out.println(redisTemplate.opsForValue().get("user"));

    }

}
