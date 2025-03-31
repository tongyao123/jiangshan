package com.example.jiangshan.config.telecomMessageApp;


/**
* @Date: 2023/11/30
* @Author: Xiao Lee
* @Param: 
* @Return: 
* @Description: telecomMessageApp.java
*/

import com.alibaba.fastjson.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class telecomMessageApp {

    public static void main(String[] args) throws Exception {
        //sendMessage("天翼云测试","17750244312","SMS64124870510","{\"code\":\"123456\"}");
        System.out.println("telecomMessageApp success");
    }

    private static void sendMessage(String signName,String phoneNumber,String templateCode,String templateParam) throws Exception {

        //请参考帮助文档填写以下内容
        Map<String, Object> params = new HashMap<>();
        //固定参数
        params.put("action", "SendSms");
        //请填写您在控制台上申请并通过的短信签名。
        params.put("signName", signName);//"天翼云测试"
        //请填写接收短信的目标手机号，多个手机号使用英文逗号分开
        params.put("phoneNumber", phoneNumber);//"17750244312"
        //请填写您在控制台上申请并通过的短信模板，此模板为测试专用模板，可直接进行测试
        params.put("templateCode", templateCode);//"SMS64124870510"
        //请填写短信模板对应的模板参数和值。此值为测试模板的变量及参数，可直接使用
        params.put("templateParam", templateParam);//"{\"code\":\"123456\"}"
        params.put("extendCode", "");// 选填
        params.put("sessionId","");  // 选填
        String body = JSONObject.toJSONString(params);

        // SETUP1:获取AccessKey和SecurityKey
        String accessKey = "7ee7e9df104b4adb98cbf35bedb9a6ac";  // 填写控制台->个人中心->安全设置->查看->AccessKey
        String securityKey = "0db41c379fd84b18bd3637fe3255a031";// 填写控制台->个人中心->安全设置->查看->SecurityKey

        // SETUP2:构造时间戳
        SimpleDateFormat TIME_FORMATTER = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyyMMdd");
        Date nowdate = new Date();
        String singerDate = TIME_FORMATTER.format(nowdate);
        String singerDd = DATE_FORMATTER.format(nowdate);
        System.out.println("singerDate:" + singerDate);
        System.out.println("singerDd:" + singerDd);

        // SETUP3:构造请求流水号
        String uuId = UUID.randomUUID().toString();
        System.out.println("uuId:" + uuId);

        // SETUP4:构造待签名字符串
        String CampmocalHeader = String.format("ctyun-eop-request-id:%s\neop-date:%s\n", uuId, singerDate);// uuid去掉this
        // header的key按照26字母进行排序, 以&作为连接符连起来

        URL url = new URL("https://sms-global.ctapi.ctyun.cn/sms/api/v1");
        String query = url.getQuery();
        String afterQuery = "";
        if (query != null) {
            String param[] = query.split("&");
            Arrays.sort(param);
            for (String str : param) {
                if (afterQuery.length() < 1)
                    afterQuery = afterQuery + str;
                else
                    afterQuery = afterQuery + "&" + str;
            }
        }

        // String body ="";
        String calculateContentHash = getSHA256(body); // 报文原封不动进行sha256摘要
        String sigtureStr = CampmocalHeader + "\n" + afterQuery + "\n" + calculateContentHash;
        System.out.println("calculateContentHash：" + calculateContentHash);
        System.out.println("sigtureStr：" + sigtureStr);

        // SETUP5:构造签名

        byte[] ktime = HmacSHA256(singerDate.getBytes(), securityKey.getBytes());
        byte[] kAk = HmacSHA256(accessKey.getBytes(), ktime);
        byte[] kdate = HmacSHA256(singerDd.getBytes(), kAk);
        String Signature = Base64.getEncoder().encodeToString(HmacSHA256(sigtureStr.getBytes("UTF-8"), kdate));

        // SETUP6:构造请求头
        HttpPost httpPost = new HttpPost(String.valueOf(url));
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setHeader("ctyun-eop-request-id", uuId);
        httpPost.setHeader("Eop-date", singerDate);
        String signHeader = String.format("%s Headers=ctyun-eop-request-id;eop-date Signature=%s", accessKey,
                Signature);
        httpPost.setHeader("Eop-Authorization", signHeader);
        System.out.println("Signature" + Signature);
        System.out.println("signHeader" + signHeader);

        httpPost.setEntity(new StringEntity(body, ContentType.create("application/json", "utf-8")));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();

             CloseableHttpResponse response = httpClient.execute(httpPost)) {
            String string = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println("返回结果：" + string);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static String toHex(byte[] data) {
        StringBuilder sb = new StringBuilder(data.length * 2);
        byte[] var2 = data;
        int var3 = data.length;
        for (int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            String hex = Integer.toHexString(b);
            if (hex.length() == 1) {
                sb.append("0");
            } else if (hex.length() == 8) {
                hex = hex.substring(6);
            }
            sb.append(hex);
        }
        return sb.toString().toLowerCase(Locale.getDefault());
    }

    private static String getSHA256(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // byte[] a = text.getBytes(StandardCharsets.UTF_8);

            md.update(text.getBytes(StandardCharsets.UTF_8));
            return toHex(md.digest());
        } catch (NoSuchAlgorithmException var3) {
            return null;
        }
    }

    private static byte[] HmacSHA256(byte[] data, byte[] key) throws Exception {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(key, "HmacSHA256"));
            return mac.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }

}



