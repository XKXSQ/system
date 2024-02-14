package com.system.config.mvc;

import com.system.config.exception.AuthException;
import com.system.config.exception.TokenException;
import com.system.util.Result;
import com.system.util.Status;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//处理全局异常
@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public Result handle(TokenException exception){
        return Result.fail();
    }

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public Result handle(AuthException exception){
        return Result.no_auth();
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result handel(RuntimeException exception){
        return Result.error(exception.getMessage());
    }
}
