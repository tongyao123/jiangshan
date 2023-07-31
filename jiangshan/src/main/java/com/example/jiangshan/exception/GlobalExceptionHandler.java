package com.example.jiangshan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 拦截业务异常，返回业务异常信息
     * @param ex
     * @return
     */
    /**
     * @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleIllegalArgumentExceptionError(IllegalArgumentException ex) {
        String message = ex.getMessage();
        return Result.fail(500, message);
    }*/
}