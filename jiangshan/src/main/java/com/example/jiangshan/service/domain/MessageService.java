package com.example.jiangshan.service.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jiangshan.client.OpenMessageClient;
import com.example.jiangshan.client.response.consume.ConsumeMessageResponse;
import com.example.jiangshan.client.response.consume.CreateConsumerResponse;
import com.example.jiangshan.mapper.domain.MessageMapper;
import com.example.jiangshan.entity.Message;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanyuechao
 * @date 2020-05-20 10:44
 **/
@Service
@Slf4j
public class MessageService {

@Autowired
    private OpenMessageClient openMessageClient;

@Autowired
    private MessageMapper messageMapper;

    private WorkerThread thread;

    public void startMessageThread() {
        if (thread != null && thread.isAlive()) {
            return;
        }
        thread = new WorkerThread();
        thread.start();
    }

    public List<Message> getMessageList() {
        return messageMapper.listAll();
    }

    public void batchInsert(List<Message> messages) {
        messageMapper.batchInsert(messages);
    }

    public class WorkerThread extends Thread {

        private boolean activeStatus = true;;

        private Long CONSUME_INTERVAL = 10000L;

        @Override
        public void run() {
            log.info("消费线程启动");
            CreateConsumerResponse response = openMessageClient.createConsunmer();
            if (response.getData() == null || response.getData().getConsumerId() == null) {
                log.info("获取消费者失败,线程退出");
                return;
            }
            log.info("获取消费者成功:{}", response.getData().getConsumerId());
            while (activeStatus) {
                try {
                    Thread.sleep(CONSUME_INTERVAL);
                    // 拉取消息
                    ConsumeMessageResponse messageResponse = openMessageClient
                            .consumeMessage(response.getData().getConsumerId(), true);
                    if (messageResponse.getData() != null) {
                        log.info("拉取到消息{}条", messageResponse.getData().size());
                        if (messageResponse.getData().size() > 0) {
                            messageMapper.batchInsert(messageResponse.getData());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
