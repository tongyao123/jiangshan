package com.example.jiangshan.service.master.wechat;

import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import com.wechat.pay.java.core.util.NonceUtil;
import com.wechat.pay.java.service.payments.jsapi.JsapiService;
import com.wechat.pay.java.service.payments.jsapi.model.Amount;
import com.wechat.pay.java.service.payments.jsapi.model.Payer;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

import static com.example.jiangshan.config.BaseConfig.*;

@Service
public class MallSelfService {
    @Value("${weChat.supplyAppId}")
    private String AppId;

    private static String privateKey = privateKeyEntity;

    PrivateKey merchantPrivateKey = PemUtil.loadPrivateKey(privateKey);

    public PrepayResponse wechatPay(String orderId, String orderAmount, String description, String openid) throws Exception {
        System.out.println(AppId);
        JsapiService service = new JsapiService.Builder().config(config).build();
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
        PrepayResponse response = service.prepay(request);
        System.out.println(response.getPrepayId());
        String prepayId = response.getPrepayId();//下单返回的prepayId
        long timestamp = System.currentTimeMillis();//时间戳
        String nonceStr = NonceUtil.createNonce(32);//随机字符串
        String pack = "prepay_id=" + prepayId;//订单详情扩展字符串setTimeStamp(String.valueOf(timestamp));
        String paySign = getSign(AppId, timestamp, nonceStr, pack);
        //System.out.println(prepayWithRequestPayment);
        System.out.println(paySign);
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