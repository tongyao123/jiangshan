package com.example.jiangshan.service.master.wechat;

import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import com.wechat.pay.java.service.payments.jsapi.JsapiServiceExtension;
import com.wechat.pay.java.service.payments.jsapi.model.Amount;
import com.wechat.pay.java.service.payments.jsapi.model.Payer;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayWithRequestPaymentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

import static com.example.jiangshan.config.JSAPI.*;

@Service
public class MallOnlineService {
    @Value("${weChat.supplyAppId}")
    private String AppId;

    private static String privateKey = privateKeyEntity;


    PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(privateKey);

    JsapiServiceExtension service =
            new JsapiServiceExtension.Builder()
                    .config(config)
                    .signType("RSA")
                    .build();

    public PrepayWithRequestPaymentResponse wechatPay(String orderId, String orderAmount, String description, String openid) throws Exception {
        System.out.println(AppId);
        // request.setXxx(val)设置所需参数，具体参数可见Request定义3
        PrepayRequest request = new PrepayRequest();
        Amount amount = new Amount();
        amount.setTotal(new BigDecimal(orderAmount).multiply(new BigDecimal("100")).intValue());
        request.setAmount(amount);
        request.setAppid(AppId);
        request.setMchid(merchantId);
        request.setDescription(description);
        request.setNotifyUrl("https://www.weixin.qq.com/wxpay/pay.php");
        request.setOutTradeNo(orderId);
        Payer payer = new Payer();
        payer.setOpenid(openid);
        request.setPayer(payer);

        PrepayWithRequestPaymentResponse response =  service.prepayWithRequestPayment(request);
        System.out.println(response.toString());


        return response;
    }

    public String getSign(String appId, long timestamp, String nonceStr, String pack) throws Exception {
        String message = buildMessage(appId, timestamp, nonceStr, pack);
        String paySign = sign(message.getBytes("utf-8"));
        return paySign;
    }

    private String buildMessage(String appId, long timestamp, String nonceStr, String pack) {
        return appId + "\n"
                + timestamp + "\n"
                + nonceStr + "\n"
                + pack + "\n";
    }

    private String sign(byte[] message) throws Exception {
        Signature sign = Signature.getInstance("SHA256withRSA");
        //这里需要一个PrivateKey类型的参数，就是商户的私钥。
        sign.initSign(merchantPrivateKey);
        sign.update(message);
        return Base64.getEncoder().encodeToString(sign.sign());
    }
}