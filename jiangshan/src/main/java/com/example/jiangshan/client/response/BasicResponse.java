package com.example.jiangshan.client.response;

import org.springframework.http.ResponseEntity;

import lombok.Data;

/**
 * @author yanyuechao
 * @date 2020-05-21 12:20
 **/
@Data
public class BasicResponse {

    private String code;
    private String message;

    public static boolean isSuccess(BasicResponse basicResponse) {
        return null != basicResponse && "200".equals(basicResponse.getCode());
    }

    public static boolean isSuccess(ResponseEntity response) {
        return null != response && 200 == response.getStatusCodeValue();
    }
}
