package com.example.jiangshan.open.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.example.jiangshan.open.service.OauthService;

/**
 * @author yanyuechao
 * @date 2020-05-21 14:31
 **/
@Component
public class BasicClient {

    @Autowired
    private OauthService oauthService;

    HttpHeaders getHttpHeaders() {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", oauthService.getAuthorization());
        requestHeaders.add("Content-Type", "application/json");
        return requestHeaders;
    }

    HttpHeaders getFormHttpHeaders() {

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", oauthService.getAuthorization());
        requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
        return requestHeaders;
    }
}
