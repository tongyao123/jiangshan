package com.example.jiangshan.service.master.wechat;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 微信登录工具类
 *
 * @description:
 * @projectName:alumni
 * @see:util
 * @author:lgb
 * @createTime:2021/8/27 17:02
 * @version:1.0
 */
public class WeChatLoginUtil {

    final Boolean flag = false;

    /**
     * description 1.获取用户的临时code
     * param [appid, redirectUrl]
     * return java.lang.String
     * authorlgb
     * createTime 2021/8/27 17:30
     **/
    public static String getUserUathUrl(String appid, String redirectUrl) throws UnsupportedEncodingException {
        StringBuffer getcodeUrl = new StringBuffer()
                .append("https://open.weixin.qq.com/connect/oauth2/authorize")
                .append("?appid=" + appid)
                .append("&redirect_uri=" + URLEncoder.encode(redirectUrl, "utf-8"))
                .append("&response_type=code")
                .append("&scope=snsapi_userinfo")
                .append("&state=" + System.currentTimeMillis())
                .append("#wechat_redirect");

        return getcodeUrl.toString();
    }

    /**
     * description  2.获取用户的openid和access_token
     * param [appid, appSecret, code]
     * return java.lang.String
     * author
     * createTime 2021/8/27 17:30
     **/
    public static String getBaseAccessTokenUrl(String appid, String appSecret, String code) throws UnsupportedEncodingException {
        StringBuffer baseAccessTokenUrl = new StringBuffer()
                .append("https://api.weixin.qq.com/sns/oauth2/access_token")
                .append("?appid=" + appid)
                .append("&secret=" + appSecret)
                .append("&code=" + code)
                .append("&grant_type=authorization_code");

        return baseAccessTokenUrl.toString();
    }

    /**
     * description  3.根据openid 获取用户的信息
     * param [accessToken, openid]
     * return java.lang.String
     * author
     * createTime 2021/8/27 17:31
     **/
    public static String getBaseUserInfoUrl(String accessToken, String openid) {
        StringBuffer baseUserInfoUrl = new StringBuffer()
                .append("https://api.weixin.qq.com/sns/userinfo")
                .append("?access_token=" + accessToken)
                .append("&openid=" + openid)
                .append("&lang=zh_CN");
        return baseUserInfoUrl.toString();
    }

    /**
     * description 4检验授权凭证（access_token）是否有效
     * param [openid, accessToken]
     * return java.lang.String
     * author
     * createTime 2021/11/29 10:16
     **/
    public static String checkAccessToken(String openid, String accessToken) {
        StringBuffer stringBuffer = new StringBuffer().append(" https://api.weixin.qq.com/sns/auth")
                .append("?access_token=" + accessToken)
                .append("&openid=" + openid);
        return stringBuffer.toString();
    }

    /**
     * description 微信小程序登录，通过code获取session_key和openid
     * param [appid, secret, code]
     * return java.lang.String
     * author
     * createTime 2021/8/30 10:15
     **/
    public static String getCode2Session(String appid, String secret, String code) {
        StringBuffer code2Session = new StringBuffer()
                .append("ttps://api.weixin.qq.com/sns/jscode2session")
                .append("?appid=" + appid)
                .append("&secret=" + secret)
                .append("&js_code=" + code)
                .append("&grant_type=authorization_code");
        return code2Session.toString();
    }


}

