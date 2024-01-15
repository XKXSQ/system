package com.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.system.mapper")
public class ForumsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumsystemApplication.class, args);
    }

}
