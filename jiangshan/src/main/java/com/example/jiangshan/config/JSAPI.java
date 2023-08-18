package com.example.jiangshan.config;

import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.RSAAutoCertificateConfig;

public class JSAPI {
    public static final String merchantId = "1636296954";
    public static final String privateKeyPath = "D:\\privateKey\\apiclient_key.pem";
    public static final String merchantSerialNumber = "2DBF0F8C1DDFF43780020628E81049536094D197";
    public static final String apiV3key = "sd15as1d56as1d56a156d156ad156as1";

    public static final String supplyAppId = "wxed05c9e3b45e9aa8";
    public static final String jiangshanAppId = "wx7e87828783de8ffc";

    public static final String privateKeyEntity = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC5fj5Og8E12QRg\n" +
            "VeGPdCY+c3BK6jtYmqAkqCYnCVc4zKdD4qgNLKK3fIfn7ZNUy2Wg28QicLmVWCsN\n" +
            "gA1VCHxol7jVt1efu1HQzanGnAXxb9jT4+S4g00bz8ww8N2rWBvS0IVm5Bz4PQKd\n" +
            "Wa4QUV0mVx7Rdl7Xkl/37h7NAb9VGwpRL3vBGSr8XBrmOsSW/ZSqv9I5YbZXehXp\n" +
            "Ig0PZ5uv16If25xAGsJsz640m4fPTjh4o/ryv+6ZQiB8r+/D6BuNuOfT9G9hpEJW\n" +
            "f0tXwAW8Z0xq5imqJoSY7XBx4T9faGylLXcz93MgLCM630sLxXdZ656Wdj2oqm6J\n" +
            "cjOhNfTPAgMBAAECggEANq64v3yn4K/xUlT/AcND4vU1DWCvzhcHTscjOC7Qv7XV\n" +
            "OXYABKI79cuIZR7sZ/ruItWmpGCG1TgAuSIezAqMYmkX3CkIc9ZM8Dkw65PjTKGk\n" +
            "UhLEwoAyoxhHIcZgErsOuL8wFHz67VNPCgP+BGF4DG1ycF1s6DAGiphwDA+P0A5/\n" +
            "/cpSknI1ihWn/VEUkVqs0QvWH3heSP/s8LLVcPsEAs2F8O0RKt/zRtGyH1JTwUzL\n" +
            "yIQRA20+EWgxXEU1NhwpLj0madUICm9Havm4AJ1Xf0Q1UiU5mkU9h7g5yLaN+nte\n" +
            "5UWYiLzap945leh9UiT1zp7s2fDFnMrG6DV9Re3igQKBgQDlWUBDAwpli17/M15+\n" +
            "Cha+hlYRQ+jhyRts5bFbllriDD6AETOypjEslhVG0WMJOzG3sMXtl8S80dYBQRhg\n" +
            "dbEKJyU6nd9S/Y9ZJO08lMZ8osSd3Y+EsN8Quw9+joRI3yO30hgvYmeEIrkiHo0/\n" +
            "XvHTkxZxPmuU0BBkdfPUZE4ACQKBgQDPDFzTO7cbJE4sg5GEh9LTcV0LVHjBCIKf\n" +
            "dvza+daz8ZjOH11dJYFNPgQrlne894kyKUmFJZQIWWnA1HgOkpHRIWDWx0MyqKzl\n" +
            "dCBGmEpPKStCqWVUT7AU0jx7C4jCi5fLm18Wp56EZK+DcOJhZcYSZca27QJKiOGm\n" +
            "LkEijulUFwKBgQDOM+eGGHbBg4Q+uMXNVm7Kj+dUEJWSYwkIaJ+Ec/N0Z4POCylL\n" +
            "BwcRSkMI7/s18oWp3QKnspuNFLBvYkJzf31UXounXwfKCvVWNdAidrTanFFgijKe\n" +
            "H5P+6+BrbeFbz1vCyt85wyTE9Z80IPnnrwqHqig0WuXI3yTN3gsCu8gxWQKBgAxX\n" +
            "3VTOc40PrgVjVpKDEmN+l6BsScKgQkFFc6+OQ2l41rY7EnLSIJI9Rzxd/Qdr7mbq\n" +
            "JTLl2Zxh0Dcps3qS7FR+W+qR+ISVn7ESKjZrL8rmVmjj9mF/WqzzF53yQxXuAn+l\n" +
            "5JZSKdYUto3sdeJ+kb9ZB+6x1HgjDui8Sy/HO0vDAoGADuFugO/+bbQBxwP+BZbu\n" +
            "nUY2xPPqI84XPN8SZJNXQnrfhcFsUUik0W2++OiTK8uzHBCwNCOwLrYSjrwhrWn3\n" +
            "Ml/XU5B8Xm34aY0ttjAOcCcwE8rerCGbZ37d4J/Yd8ttSP/ozcq9OSxZ9hz/Ybg8\n" +
            "9imZscH+ZeL4Vljcw5bRV4g=\n" +
            "-----END PRIVATE KEY-----\n";

    public static final Config config =
            new RSAAutoCertificateConfig.Builder()
                    .merchantId(merchantId)
                    .privateKeyFromPath(privateKeyPath)
                    .merchantSerialNumber(merchantSerialNumber)
                    .apiV3Key(apiV3key)
                    .build();
}