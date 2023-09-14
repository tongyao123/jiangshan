package com.example.jiangshan.open.client.response.consume;

import com.example.jiangshan.open.client.response.BasicResponse;

import lombok.Data;

/**
 * 
 * <p>创建消费者返回</p>
 *
 * @author  zhangkai21  
 * @date 2020年5月26日 下午9:47:15
 */
@Data
public class CreateConsumerResponse extends BasicResponse {

    private Consumer data;

    @Data
    public static class Consumer {
        private String consumerId;
    }
}
