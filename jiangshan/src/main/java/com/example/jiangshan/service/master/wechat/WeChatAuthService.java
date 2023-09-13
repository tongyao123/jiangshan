package com.example.jiangshan.service.master.wechat;

import com.example.jiangshan.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;


@Service
public class WeChatAuthService {

    @Value("${weChat.jiangshanAppId}")
    private String appId;

    @Value("${weChat.jiangshanSecret}")
    private String appSecret;

    public String getAuthorizeUrl(String code) {
        // 构建授权 URL
        // ...
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        return url;
    }

    public String getAccessToken(String code) {
        // 获取 access token
        // ...
        OkHttpClient client = new OkHttpClient();
        String url = code; // 替换 URL
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                System.out.println("Response: " + responseBody);
                return responseBody;
            } else {
                System.out.println("HTTP request failed with response code: " + response.code());
                return "HTTP request failed with response code: " + response.code();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "结束";
    }


    public User getUserInfo(String accessToken) {
        // 获取用户信息
        // ...

        return new User();
    }
}