package com.example.jiangshan.open.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jiangshan.open.domain.entity.Message;
import com.example.jiangshan.open.service.MessageService;

import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * 开发者服务demo-认证管理相关API
 */
@RestController
@RequestMapping("/demo")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @CrossOrigin
    @ApiOperation(value = "开始获取消息")
    @PostMapping("/messages/actions/start")
    public HttpResult<String> startConsumeThread() {
        messageService.startMessageThread();
        return new HttpResult<>();
    }

    @CrossOrigin
    @ApiOperation(value = "获取消息列表")
    @GetMapping("/messages/list")
    public HttpResult<List<Message>> getMessageList() {
        return new HttpResult<>(messageService.getMessageList());
    }

    @CrossOrigin
    @ApiOperation(value = "添加测试消息")
    @PostMapping("/messages/testAdd")
    public HttpResult<String> batchInsertTest(@RequestBody addParam param) {
        messageService.batchInsert(param.getMessages());
        return new HttpResult<>();
    }

    @Data
    public static class addParam {
        private List<Message> messages;
    }
}
