package com.example.jiangshan.open.api;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.example.jiangshan.open.exception.BusinessException;
import com.example.jiangshan.open.exception.ExceptionInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class HttpResult<T> {

        public static final int OK = 0;
        @ApiModelProperty(value = "消息码", required = true, example = "0")
        private Integer code = 0;
        @ApiModelProperty(value = "提示信息。主要用于开发调试，不建议显示给用户", required = true)
        private String message;
        @ApiModelProperty(value = "返回包体", required = true)
        private T data;
        @ApiModelProperty(value = "是否正常返回", required = true, example = "true", notes = "主要预留给某些不方便判断code的场景，只要code不是0，这个字段就是false")
        private boolean success = true;

        public HttpResult() {
        }

        public HttpResult(T data) {
            this.data = data;
        }

        /**
         * 默认成功返回带消息
         * @param data
         * @return
         */
        protected HttpResult<T> responseOK(T data) {
            HttpResult<T> restResult = new HttpResult<>();
            restResult.setData(data);
            restResult.setCode(OK);
            return restResult;
        }

        public static HttpResult generateErrorResult(ExceptionInfo exceptionInfo) {
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(exceptionInfo.getCode());
            httpResult.setMessage(exceptionInfo.getMessage());
            httpResult.setSuccess(false);
            return httpResult;
        }

        public static HttpResult generateErrorResult(int code, String message) {
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(code);
            httpResult.setMessage(message);
            httpResult.setSuccess(false);
            return httpResult;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
            if (code != OK) {
                this.success = false;
            }
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        @Override
        public String toString() {
            return "HttpResult [code=" + code + ", message=" + message + ", data=" + data + ", success=" + success + "]";
        }

        public static <T> T getResult(HttpResult<T> result, ExceptionInfo exceptionInfo) {
            T data = null;
            if (null != result && result.getCode() == 0) {
                data = result.getData();
            } else {
                throw new BusinessException(exceptionInfo);
            }
            return data;
        }

        /**
          * 使用时   httpResult.getOptionalData().orElse(default);
          * @return http实际请求的数据的Optional值
          * @author xuweidong
          */
        @JsonIgnore
        public Optional<T> getDataOptional() {
            return Optional.ofNullable(data);
        }

    }
