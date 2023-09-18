package com.example.jiangshan.controller;

import com.example.jiangshan.controller.vo.OauthVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jiangshan.client.response.AccountTokenResponse.Account;
import com.example.jiangshan.service.domain.OauthService;

import io.swagger.annotations.ApiOperation;

/**
 * 开发者服务demo-认证管理相关API
 */
@RestController
@RequestMapping("/demo")
public class OauthController {
    @Autowired
    private OauthService oauthService;

    @CrossOrigin
    @ApiOperation(value = "开发者获取云眸token")
    @PostMapping("/oauth/info")
    public HttpResult<OauthVO> getThirdToken() {
        String accessToken = oauthService.getToken();
        OauthVO oauthVO = new OauthVO();
        oauthVO.setToken(accessToken);
        return new HttpResult<>(oauthVO);
    }

    @CrossOrigin
    @ApiOperation(value = "开发者获取取流token")
    @PostMapping("/account/info")
    public HttpResult<Account> getAccountToken() {
        return new HttpResult<>(oauthService.getAccessToken());
    }

}
