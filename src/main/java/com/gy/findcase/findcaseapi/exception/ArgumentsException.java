package com.gy.findcase.findcaseapi.exception;

public class ArgumentsException extends RuntimeException {

    public ArgumentsException(String message) {
        super("参数错误:" + message);
    }
}
