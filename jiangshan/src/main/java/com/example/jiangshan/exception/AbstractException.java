package com.example.jiangshan.exception;

abstract class AbstractException extends RuntimeException implements ExceptionInfo {
    private static final long serialVersionUID = 3289598099629324399L;
    private final int code;
    private final String message;
    private final transient Object body;
    public AbstractException(ExceptionInfo info){
        this.code = info.getCode();
        this.message = info.getMessage();
        this.body = null;
    }


    public AbstractException(int code){
        this.code = code;
        this.message = null;
        this.body = null;
    }

    public AbstractException(ExceptionInfo info, Object body){
        this.code = info.getCode();
        this.message = info.getMessage();
        this.body = body;
    }

    public AbstractException(int code, String message){
        this.code = code;
        this.message = message;
        this.body = null;
    }
    @Override
    public String getMessage() {
        return message;
    }
    @Override
    public int getCode() {
        return code;
    }
    public Object getBody() {
        return body;
    }
}
