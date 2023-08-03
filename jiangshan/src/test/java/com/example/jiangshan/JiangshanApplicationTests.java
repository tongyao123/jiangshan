package com.example.jiangshan;

import com.example.jiangshan.Data.JSAPI;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import com.wechat.pay.java.service.payments.jsapi.JsapiService;
import com.wechat.pay.java.service.payments.jsapi.model.Amount;
import com.wechat.pay.java.service.payments.jsapi.model.Payer;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        // 使用自动更新平台证书的RSA配置
        // 一个商户号只能初始化一个配置，否则会因为重复的下载任务报错
        Config config =
                new RSAAutoCertificateConfig.Builder()
                        .merchantId(JSAPI.merchantId)
                        .privateKeyFromPath(JSAPI.privateKeyPath)
                        .merchantSerialNumber(JSAPI.merchantSerialNumber)
                        .apiV3Key(JSAPI.apiV3key)
                        .build();
        JsapiService service = new JsapiService.Builder().config(config).build();
        // request.setXxx(val)设置所需参数，具体参数可见Request定义
        PrepayRequest request = new PrepayRequest();
        Amount amount = new Amount();
        amount.setTotal(100);
        request.setAmount(amount);
        request.setAppid("wxed05c9e3b45e9aa8");
        request.setMchid("1636296954");
        request.setDescription("测试商品标题");
        request.setNotifyUrl("https://www.weixin.qq.com/wxpay/pay.php");
        request.setOutTradeNo("out_trade_no_20230803001");
        Payer payer = new Payer();
        payer.setOpenid("o18cr5WOEt64u1l1Aud_iAOXd8TI");
        request.setPayer(payer);
        PrepayResponse response = service.prepay(request);
        System.out.println(response.getPrepayId());
    }

}
