package com.example.jiangshan.service.master.screen;

import com.example.jiangshan.config.JSAPI;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import com.wechat.pay.java.service.payments.jsapi.JsapiService;
import com.wechat.pay.java.service.payments.jsapi.model.Amount;
import com.wechat.pay.java.service.payments.jsapi.model.Payer;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayResponse;
import org.springframework.stereotype.Service;

import static com.example.jiangshan.config.JSAPI.*;


@Service
public class MallService {
    Config config =
            new RSAAutoCertificateConfig.Builder()
                    .merchantId(merchantId)
                    .privateKeyFromPath(privateKeyPath)
                    .merchantSerialNumber(merchantSerialNumber)
                    .apiV3Key(apiV3key)
                    .build();

    public PrepayResponse wechatPay(String orderId,String orderAmount){
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
        request.setOutTradeNo(orderId);
        Payer payer = new Payer();
        payer.setOpenid("5");
        request.setPayer(payer);
        PrepayResponse response = service.prepay(request);
        System.out.println(response.getPrepayId());
        return response;
    }
}
