package com.example.jiangshan.config;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;

public class JSAPI {
    public static final String merchantId = "";
    public static final String privateKeyPath = "D:\\privateKey\\apiclient_key.pem";
    public static final String merchantSerialNumber = "";
    public static final String apiV3key = "";

    public static final String supplyAppId = "";
    public static final String jiangshanAppId = "";

    public static final String privateKeyEntity = "";

    public static final Config config =
            new RSAAutoCertificateConfig.Builder()
                    .merchantId(merchantId)
                    .privateKeyFromPath(privateKeyPath)
                    .merchantSerialNumber(merchantSerialNumber)
                    .apiV3Key(apiV3key)
                    .build();
}

