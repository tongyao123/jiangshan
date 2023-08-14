package com.example.jiangshan.service.master.wechat;

import com.example.jiangshan.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeChatAuthService {

    @Value("${weChat.jiangshanAppId}")
    private String appId;

    @Value("${weChat.appSecret}")
    private String appSecret;

    public String getAuthorizeUrl() {
        // 构建授权 URL
        // ...
        return "";
    }

    public String getAccessToken(String code) {
        // 获取 access token
        // ...
        return "";
    }

    public User getUserInfo(String accessToken) {
        // 获取用户信息
        // ...

        return new User();
    }
}