package com.example.jiangshan.client;

import java.util.HashMap;
import java.util.Map;

import com.example.jiangshan.client.response.BasicResponse;
import com.example.jiangshan.client.response.consume.CreateConsumerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.jiangshan.client.response.consume.ConsumeMessageResponse;
import com.example.jiangshan.constant.ExceptionEnum;
import com.example.jiangshan.util.Assert;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <p>消息通道</p>
 *
 * @author  zhangkai21  
 * @date 2020年5月27日 下午5:20:45
 */
@Slf4j
@Component
public class OpenMessageClient extends BasicClient {
	
    public static final String CREATE_CONSUMER_URL = "/api/v1/mq/consumer/group1";

    public static final String CONSUME_MESSAGE_URL = "/api/v1/mq/consumer/messages";

    public static final String SUBMIT_OFFSET_URL = "/api/v1/mq/consumer/offsets";

    @Value("${OPEN_URL:http://peer3}")
    private String host;
    @Autowired
    private RestTemplate openRestTemplate;

    public CreateConsumerResponse createConsunmer() {

        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        CreateConsumerResponse result = openRestTemplate.postForObject(host + CREATE_CONSUMER_URL, request,
                CreateConsumerResponse.class);
        log.info("CreateConsumerResponse:{}", result);
        Assert.isTrue(BasicResponse.isSuccess(result), ExceptionEnum.CREATE_CONSUMER_ERROR);
        return result;
    }

    public ConsumeMessageResponse consumeMessage(String consumerId, Boolean autoCommit) {
        StringBuilder params = new StringBuilder();
        params.append("consumerId=");
        params.append(consumerId);
        params.append("&");
        params.append("autoCommit=");
        params.append("true");
        HttpEntity<String> request = new HttpEntity<>(params.toString(), getFormHttpHeaders());
        ConsumeMessageResponse result = openRestTemplate.postForObject(host + CONSUME_MESSAGE_URL, request,
                ConsumeMessageResponse.class, params);
        Assert.isTrue(BasicResponse.isSuccess(result), result, ExceptionEnum.CONSUME_MESSAGE_ERROR);
        return result;
    }

    public BasicResponse submitOffsets(String consumerId) {
        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        Map<String, Object> params = new HashMap<>();
        params.put("consumerId", consumerId);
        BasicResponse result = openRestTemplate.postForObject(host + CONSUME_MESSAGE_URL, request,
                BasicResponse.class, params);
        Assert.isTrue(BasicResponse.isSuccess(result), ExceptionEnum.CONSUME_MESSAGE_ERROR);
        return result;
    }
}