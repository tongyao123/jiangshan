package com.example.jiangshan.exception;

public class BusinessException extends AbstractException {
    private static final long serialVersionUID = -4853537210488828688L;
    public BusinessException(ExceptionInfo info) {
        super(info);
    }

    public BusinessException(int code){
        super(code);
    }
    public BusinessException(ExceptionInfo info, Object body) {
        super(info, body);
    }
    public BusinessException(int code, String message){
        super(code, message);
    }
}
