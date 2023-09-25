package com.example.jiangshan;

import com.example.jiangshan.Data.JSAPI;
import com.example.jiangshan.service.master.screen.TalentsService;
import com.example.jiangshan.service.master.wechat.WeChatAuthService;
import com.wechat.pay.java.core.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.example.jiangshan.config.cameraConfig.*;
import static com.example.jiangshan.config.cameraConfig.scope;

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
    public HttpClient httpClient;

    /*@Test
    public void contextLoads() {
        System.out.println("begin-------------------------------------------------");
       *//* String requestPath = "https://api2.hik-cloud.com/oauth/token";
        HttpHeaders headers = new HttpHeaders();
        headers.addHeader("Accept", MediaType.APPLICATION_JSON.getValue());
        headers.addHeader("Content-Type", MediaType.APPLICATION_JSON.getValue());
        HttpRequest httpRequest = (new HttpRequest.Builder()).httpMethod(HttpMethod.POST).url(requestPath).headers(headers).body(this.createRequestBody(request)).build();
        HttpResponse<PrepayResponse> httpResponse = this.httpClient.execute(httpRequest, PrepayResponse.class);
        System.out.println((PrepayResponse) httpResponse.getServiceResponse());*//*
        System.out.println("begin-------------------------------------------------");

    }

    @Test
    public void test1() {
        System.out.println("begin-------------------------------------------------");*//*
        System.out.println(talentsService.getTalentsStatistics());
        String url = weChatAuthService.getAuthorizeUrl("17750244312");
        System.out.println(weChatAuthService.getAccessToken(url));*//*
        System.out.println("begin-------------------------------------------------");
    }*/
    @Test
    public void HttpClientExample() throws IOException {
        System.out.println("begin-------------------------------------------------");
        // 设置请求URL
        String url = "https://api2.hik-cloud.com/oauth/token";

        // 设置POST请求的报文内容
        String requestBody = "client_id=" + client_id + "&client_secret=" + client_secret + "&grant_type=" + grant_type + "&scope=" + scope;

        // 创建URL对象
        URL apiUrl = new URL(url);

        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        // 设置请求方法为POST
        connection.setRequestMethod("POST");

        // 设置请求头
        connection.setRequestProperty("Host", "api2.hik-cloud.com");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        // 启用输入和输出流
        connection.setDoOutput(true);

        // 获取输出流并写入请求体数据
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("UTF-8");
            os.write(input, 0, input.length);
        }

        // 获取响应
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // 读取响应内容
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // 输出响应内容
                System.out.println("Response: " + response.toString());
            }
        } else {
            System.out.println("HTTP Request Failed with error code: " + responseCode);
        }

        // 关闭连接
        connection.disconnect();

        System.out.println("begin-------------------------------------------------");
    }

    @Test
    public void HttpClientExample1() throws IOException {
        System.out.println("begin-------------------------------------------------");
        // 设置请求URL
        String url = "https://api2.hik-cloud.com/v1/auth/open/getVideoToken";

        // 设置POST请求的报文内容
        String requestBody = "client_id=" + client_id + "&client_secret=" + client_secret + "&grant_type=" + grant_type + "&scope=" + scope;

        // 创建URL对象
        URL apiUrl = new URL(url);

        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        // 设置请求方法为POST
        connection.setRequestMethod("POST");

        // 设置请求头
        connection.setRequestProperty("Host", "api2.hik-cloud.com");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("Authorization", "Bearer e2424f58-8c5b-4a2c-9b8e-d6e6bd444f86");

        // 启用输入和输出流
        connection.setDoOutput(true);

        // 获取输出流并写入请求体数据
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = requestBody.getBytes("UTF-8");
            os.write(input, 0, input.length);
        }

        // 获取响应
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // 读取响应内容
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // 输出响应内容
                System.out.println("Response: " + response.toString());
            }
        } else {
            System.out.println("HTTP Request Failed with error code: " + responseCode);
        }

        // 关闭连接
        connection.disconnect();

        System.out.println("begin-------------------------------------------------");
    }
    //"access_token":"e2424f58-8c5b-4a2c-9b8e-d6e6bd444f86"

    @Test
    public void HttpClientExample2() {

        System.out.println("begin-------------------------------------------------");
        try {
            // 设置请求URL
            String url = "https://api2.hik-cloud.com/api/v1/open/basic/devices/actions/encrypt/off";

            // 构建JSON请求体
            String jsonRequestBody = "{\"deviceSerial\": \"AC6127825\", \"validateCode\": \"hik12345\"}";

            // 创建URL对象
            URL apiUrl = new URL(url);

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // 设置请求方法为POST
            connection.setRequestMethod("POST");

            // 设置请求头
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            // 启用输入和输出流
            connection.setDoOutput(true);

            // 获取输出流并写入JSON请求体数据
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonRequestBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // 获取响应
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 处理成功响应
                // TODO: 读取响应内容或执行其他操作
            } else {
                // 处理错误响应
                System.out.println("HTTP Request Failed with error code: " + responseCode);
            }

            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("end-------------------------------------------------");
    }

}
