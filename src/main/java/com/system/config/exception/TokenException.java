package com.system.config.exception;


//该类专门用来处理token异常问题
public class TokenException extends RuntimeException{

    public TokenException(String message) {
        super(message);
    }
}
