package com.example.jiangshan.open.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.jiangshan.open.cache.ConsumeCache;
import com.example.jiangshan.open.client.OpenBasicClient;
import com.example.jiangshan.open.client.response.AccountTokenResponse;
import com.example.jiangshan.open.client.response.AccountTokenResponse.Account;
import com.example.jiangshan.open.dto.OAuth2TokenDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * 开发者服务Demo-认证相关业务逻辑
 *
 * @author guanhaoyuan
 * @date 2020年1月19日 15:58:27
 */
@Service
@Slf4j
public class OauthService {

    @Autowired
    private OpenBasicClient openBasicClient;

    @Value("${CLIENT_ID}")
    private String clientId;
    @Value("${CLIENT_SECRET}")
    private String clientSecret;

    /**
     * 开发者登入开发者服务获取云眸access_token
     */
    public String getToken() {

        String existToken = ConsumeCache.get("open:" + clientId + ":" + clientSecret);
        if (StringUtils.isNotBlank(existToken)) {
            log.info("获取缓存中的token");
            return existToken;
        }

        return createToken(clientId, clientSecret);
    }

    public Account getAccessToken() {

        Account cachedAccount = ConsumeCache.getAccount("open:" + clientId);
        if (cachedAccount != null) {
            log.info("获取缓存中的Account");
            return cachedAccount;
        }

        return refreshAccount(clientId, clientSecret);
    }

    public String getAuthorization() {
        return "bearer " + getToken();
    }

    private String createToken(String clientId, String clientSecret) {

        OAuth2TokenDTO oAuth2TokenDTO = openBasicClient.getOauth2TokenDTO(clientId, clientSecret);
        String token = oAuth2TokenDTO.getAccess_token();
        ConsumeCache.set("open:" + clientId + ":" + clientSecret, token);
        return token;
    }

    private Account refreshAccount(String clientId, String clientSecret) {

        AccountTokenResponse response = openBasicClient.getAccountToken();
        ConsumeCache.setAccount("open:" + clientId + ":" + clientSecret, response.getData());
        return response.getData();
    }

}
