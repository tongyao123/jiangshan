package com.example.jiangshan.config;

import com.example.jiangshan.config.JSAPI;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import com.wechat.pay.java.service.payments.jsapi.JsapiService;
import com.wechat.pay.java.service.payments.jsapi.model.Amount;
import com.wechat.pay.java.service.payments.jsapi.model.Payer;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayResponse;

/** JSAPI 下单为例 */
public class QuickStart {

  /** 商户号 */
  public static String merchantId = JSAPI.merchantId;
  /** 商户API私钥路径 */
  public static String privateKeyPath = JSAPI.privateKeyPath;
  /** 商户证书序列号 */
  public static String merchantSerialNumber = JSAPI.merchantSerialNumber;
  /** 商户APIV3密钥 */
  public static String apiV3key = JSAPI.apiV3key;

  public static void main(String[] args) {
    // 使用自动更新平台证书的RSA配置
    // 一个商户号只能初始化一个配置，否则会因为重复的下载任务报错
    Config config =
        new RSAAutoCertificateConfig.Builder()
            .merchantId(merchantId)
            .privateKeyFromPath(privateKeyPath)
            .merchantSerialNumber(merchantSerialNumber)
            .apiV3Key(apiV3key)
            .build();
    JsapiService service = new JsapiService.Builder().config(config).build();
    // request.setXxx(val)设置所需参数，具体参数可见Request定义
    PrepayRequest request = new PrepayRequest();
    Amount amount = new Amount();
    amount.setTotal(100);
    request.setAmount(amount);
    request.setAppid(JSAPI.jiangshanAppId);
    request.setMchid(merchantId);
    request.setDescription("测试商品标题");
    request.setNotifyUrl("https://www.weixin.qq.com/wxpay/pay.php");
    request.setOutTradeNo("out_trade_no_001");
    Payer payer = new Payer();
    payer.setOpenid("o18cr5WOEt64u1l1Aud_iAOXd8TI");
    request.setPayer(payer);
    PrepayResponse response = service.prepay(request);
    System.out.println(response.getPrepayId());
  }
}
