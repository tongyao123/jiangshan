package com.example.jiangshan.open.client.response.consume;

import java.util.List;

import com.example.jiangshan.open.client.response.BasicResponse;
import com.example.jiangshan.open.domain.entity.Message;

import lombok.Data;

/**
 * 
 * <p>消费消息返回</p>
 *
 * @author  zhangkai21  
 * @date 2020年5月26日 下午9:48:40
 */
@Data
public class ConsumeMessageResponse extends BasicResponse {

    private List<Message> data;
}
