package com.system.config.mvc;

import com.system.config.exception.TokenException;
import com.system.config.redis.RedisUtil;
import com.system.util.Status;
import com.system.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//token拦截器
//只有token存在时，用户才能访问所有请求，若token失效，则用户只能访问login请求
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token  = request.getHeader("token");
        boolean flag = redisUtil.hasKey(token);
        if(flag){
            UserThreadLocal.set(token);
            redisUtil.expire(token,RedisUtil.EXPR);
        }else{
            throw new TokenException(Status.TOKEN_ERROR.getMsg());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}
