package com.example.jiangshan;

import com.example.jiangshan.Data.JSAPI;
import com.example.jiangshan.service.domain.MyPushMessageService;
import com.example.jiangshan.service.master.screen.AgricultureService;
import com.example.jiangshan.service.master.screen.PartyService;
import com.example.jiangshan.service.master.screen.TalentsService;
import com.example.jiangshan.service.master.wechat.WeChatAuthService;
import com.example.jiangshan.service.supply.FarmService;
import com.hikvision.building.cloud.exception.AuthException;
import com.hikvision.building.cloud.exception.ConsumeException;
import com.hikvision.building.cloud.exception.ConsumerFullException;
import com.hikvision.building.cloud.exception.NoServiceException;
import com.wechat.pay.java.core.http.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

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
    @Autowired
    MyPushMessageService myPushMessageService;
    @Autowired
    AgricultureService agricultureService;
    @Autowired
    FarmService farmService;
    @Autowired
    PartyService partyService;
    @Value("${CLIENT_ID}")
    private String CLIENT_ID;

    @Value("${CLIENT_SECRET}")
    private String CLIENT_SECRET;

    public HttpClient httpClient;

    @Test
    public void contextLoads() {
        System.out.println("begin-------------------------------------------------");

//        List<HashMap>  text =  farmService.selectFarmList("TOM1667025818560",null);
        HashMap<String,Object> text=  agricultureService.agricultureStatistics("TOM1667025818560",null);
        System.out.println(text);
        System.out.println("end-------------------------------------------------");

    }

    @Test
    public void test1() throws NoServiceException, ConsumeException, ConsumerFullException, AuthException, IOException, InterruptedException {
        System.out.println("begin-------------------------------------------------");

        String consumerId = myPushMessageService.getConsumerId(CLIENT_ID, CLIENT_SECRET, "group1");
        myPushMessageService.getOpenPassengerFlow("e42f3db5-146f-4871-bf46-85d77ad0f127",consumerId);
       Thread.sleep(2000);
        myPushMessageService.getOpenPassengerFlow("e42f3db5-146f-4871-bf46-85d77ad0f127",consumerId);

        System.out.println("end-------------------------------------------------");
    }
   /* @Test
    public void HttpClientExample() throws IOException {
        System.out.println("begin-------------------------------------------------");
        // 设置请求URL
        String url = "https://api2.hik-cloud.com/oaut h/token";

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
    }*/

}
