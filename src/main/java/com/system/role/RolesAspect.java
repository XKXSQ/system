package com.system.role;

import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;
import com.system.config.exception.AuthException;
import com.system.config.redis.RedisUtil;
import com.system.util.Status;
import com.system.util.UserThreadLocal;
import com.system.vo.LoginData;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class RolesAspect {

    @Autowired
    private RedisUtil redisUtil;

    @Pointcut
    public void pointCut(){

    }

    @Before("execution(* com.system.controller.*Controller.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzz");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //获取执行的方法（调用了哪个controller方法）
        System.out.println(method.getName());
        RequiresRoles requiresRoles = method.getAnnotation(RequiresRoles.class);
        if(requiresRoles != null){
            String token = UserThreadLocal.get();
            LoginData loginData = (LoginData) redisUtil.get(token);
            System.out.println(loginData.getType());
            System.out.println(requiresRoles.type().getCode());
            if(loginData != null){
                if(!String.valueOf(loginData.getType()).equals(String.valueOf(requiresRoles.type().getCode()))){
                    System.out.println("没有权限");
                    throw new AuthException(Status.NO_AUTH.getMsg());
                }
            }else {
                throw new AuthException(Status.NO_AUTH.getMsg());
            }

            System.out.println(requiresRoles);
            System.out.println(requiresRoles.type().getCode());
            System.out.println(requiresRoles.type().getType());
        }

    }

}
