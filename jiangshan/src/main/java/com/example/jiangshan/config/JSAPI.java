package com.example.jiangshan.config;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;

public class JSAPI {
    public static final String merchantId = "";
    public static final String privateKeyPath = "E:\\龙岩\\privateKey\\apiclient_key.pem";
    public static final String merchantSerialNumber = "";
    public static final String apiV3key = "";

    public static final String supplyAppId = "wxed05c9e3b45e9aa8";
    public static final String jiangshanAppId = "wx7e87828783de8ffc";

    public static final String privateKeyEntity = "";

    public static final Config config =
            new RSAAutoCertificateConfig.Builder()
                    .merchantId(merchantId)
                    .privateKeyFromPath(privateKeyPath)
                    .merchantSerialNumber(merchantSerialNumber)
                    .apiV3Key(apiV3key)
                    .build();
}
