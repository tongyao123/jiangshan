package com.example.jiangshan.service.domain;

import com.hikvision.building.cloud.Consumer;
import com.hikvision.building.cloud.exception.*;
import com.hikvision.building.cloud.http.ConsumerResult;
import com.hikvision.building.cloud.http.Message;
import com.hikvision.building.cloud.service.IPushMessageService;
import com.hikvision.building.cloud.service.PullMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MyPushMessageService implements IPushMessageService {

    @Value("${CLIENT_ID}")
    private String CLIENT_ID;

    @Value("${CLIENT_SECRET}")
    private String CLIENT_SECRET;

    @Override
    public void pushMessage(List<Message> messageList) {

        String clientId = CLIENT_ID;

        String clientSecret = CLIENT_SECRET;

        MyPushMessageService myPushMessageService = new MyPushMessageService();

        Consumer consumer = new Consumer(clientId, clientSecret, myPushMessageService);

        // 启动消费线程
        consumer.run();
        // TODO Auto-generated method stub
        // 异步处理消费到的消息

    }
  public String  getConsumerId(String CLIENT_ID, String CLIENT_SECRET, String consumerGroup)throws NoServiceException, ConsumeException, ConsumerFullException, AuthException, IOException{
      String accessToken;
      PullMessageService pullMessageService = new PullMessageService();
      try {
          accessToken = pullMessageService.getAccessToken(CLIENT_ID, CLIENT_SECRET);
      } catch (IOException e) {
          throw new RuntimeException(e);
      } catch (AuthException e) {
          throw new RuntimeException(e);
      }
      ConsumerResult consumerResult = pullMessageService.getConsumer(consumerGroup,accessToken);
      return consumerResult.getConsumerId();
  }
    public List<Message> getOpenPassengerFlow(String accessToken, String consumerId) throws NoServiceException, ConsumeException, ConsumerFullException, AuthException, IOException {


        PullMessageService pullMessageService = new PullMessageService();
        Boolean AutoCommit=true;
        List<Message> messageList;

        try {
            messageList  = pullMessageService.pullMessages(accessToken,consumerId,AutoCommit);
        } catch (InvalidConsumerException e) {
            throw new RuntimeException(e);
        }
        for (Message message : messageList){
            System.out.println("message----------------------"+message.getMsgId());
        }
//        System.out.println("messageListData----------------------"+messageList);
        return messageList;
    }

}