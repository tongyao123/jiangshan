package com.example.jiangshan.service.master.camera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.jiangshan.config.cameraConfig.*;

public class cameraService {
    public String getAccess_token() throws IOException {
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
                connection.disconnect();
                // 关闭连接
                return response.toString();
            }
        } else {
            connection.disconnect();
            // 关闭连接
            System.out.println("HTTP Request Failed with error code: " + responseCode);
            throw new IOException("获取access_token请求失败，HTTP Request Failed with error code: " + responseCode);
        }
    }

}
