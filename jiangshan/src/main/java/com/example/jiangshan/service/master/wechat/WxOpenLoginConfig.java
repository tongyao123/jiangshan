package com.example.jiangshan.service.master.wechat;


import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: 微信相关信息配置
 * @projectName:alumni
 * @see:mobile.config
 * @author:
 * @createTime:2021/8/30 9:31
 * @version:1.0
 */
@Component
@Data
public class WxOpenLoginConfig implements InitializingBean {

    //微信登录的appid,应用唯一标识
    @Value("${weChat.jiangshanAppId}")
    private String appId;
    // 微信登录的应用密钥AppSecret
    @Value("${weChat.jiangshanSecret}")
    private String appSecret;

    //重定向地址，使用urlEncode对链接进行处理
    @Value("${weChat.jiangshanAppId}")
    private String redirectUrl;
    //token
    @Value("${weChat.jiangshanAppId}")
    private String appToken;
    //消息加解密秘钥
    @Value("${weChat.jiangshanAppId}")
    private String encodingAESKey;


    //微信小程序登录录的appid,应用唯一标识
    @Value("${weChat.jiangshanAppId}")
    private String appletAppId;
    // 微信小程序登录的应用密钥AppSecret
    @Value("${weChat.jiangshanSecret}")
    private String appletAppSecret;


    public static String WX_OPEN_APP_ID;
    public static String WX_OPEN_APP_SECRET;
    public static String WX_OPEN_REDIRECT_URL;//回调地址


    public static String WX_APPLET_APP_ID;
    public static String WX_APPLET_APP_SECRET;


    @Override
    public void afterPropertiesSet() throws Exception {
        WX_OPEN_APP_ID = appId;
        WX_OPEN_APP_SECRET = appSecret;
        WX_OPEN_REDIRECT_URL = redirectUrl;
        WX_APPLET_APP_ID = appletAppId;
        WX_APPLET_APP_SECRET = appletAppSecret;

    }
}


