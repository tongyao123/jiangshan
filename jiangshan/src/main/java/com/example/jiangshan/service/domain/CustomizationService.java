package com.example.jiangshan.service.domain;

import com.example.jiangshan.client.OpenBasicClient;
import com.example.jiangshan.controller.HttpResult;
import com.example.jiangshan.controller.param.DeviceAddParam;
import com.example.jiangshan.mapper.domain.DeviceMapper;
import com.example.jiangshan.mapper.domain.GroupMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomizationService {
    @Autowired
    private OpenBasicClient openBasicClient;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private GroupMapper groupMapper;

    public HttpResult storeInfo(DeviceAddParam deviceAddParam) {

        return new HttpResult<>();

    }
}
