package com.example.jiangshan.exception;

public class ErrorResponse {
    private String error;

    private String message;

    public ErrorResponse(String internal_server_error, String message) {
        this.error = internal_server_error;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    // 构造函数、getter 和 setter 方法
}