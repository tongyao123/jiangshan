package com.example.jiangshan;

import com.example.jiangshan.Data.JSAPI;
import com.example.jiangshan.service.master.screen.TalentsService;
import com.example.jiangshan.service.master.wechat.WeChatAuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JiangshanApplicationTests {
    /**
     * 商户号
     */
    public static String merchantId = JSAPI.merchantId;
    /**
     * 商户API私钥路径
     */
    public static String privateKeyPath = JSAPI.privateKeyPath;
    /**
     * 商户证书序列号
     */
    public static String merchantSerialNumber = JSAPI.merchantSerialNumber;
    /**
     * 商户APIV3密钥
     */
    public static String apiV3key = JSAPI.apiV3key;
    @Autowired
    WeChatAuthService weChatAuthService;
    @Autowired
    TalentsService talentsService;


    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {
        System.out.println("begin-------------------------------------------------");
        System.out.println(talentsService.getTalentsStatistics());
        String url = weChatAuthService.getAuthorizeUrl("17750244312");
        System.out.println(weChatAuthService.getAccessToken(url));
        System.out.println("begin-------------------------------------------------");
    }
}
