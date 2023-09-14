package com.example.jiangshan.open.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import com.example.jiangshan.open.client.OpenBasicClient;
import com.example.jiangshan.open.client.response.DevicePageResponse;
import com.example.jiangshan.open.client.response.GroupListResponse;
import com.example.jiangshan.open.client.response.PersonPageResponse;
import com.example.jiangshan.open.domain.entity.Person;
import com.example.jiangshan.open.service.*;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicDataLoader implements ApplicationListener<ServiceReadyEvent> {

    @Autowired
    private OpenBasicClient openBasicClient;
    @Autowired
    private GroupService groupService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private ChannelService channelService;
    @Autowired
    private PersonService personService;
    @Autowired
    private PermissionGroupService permissionGroupService;
    @Autowired
    private CardService cardService;

    /**
     * 向内存数据库初始化数据
     * @param event
     */
    @Override
    public void onApplicationEvent(ServiceReadyEvent event) {

        //初始化组数据
        List<GroupListResponse.GroupRow> groupRows = openBasicClient.listGroups();
        groupService.batchAddGroup(groupRows);

        // 初始化设备数据
        List<DevicePageResponse.DevicePage.DeviceRow> deviceRows = openBasicClient.listDevices();
        deviceService.batchAddDevices(deviceRows);

        // 初始化通道数据
        channelService.batchAddChannels(deviceRows);

        // 初始化人员数据
        List<PersonPageResponse.PersonPage.PersonRow> personRows = openBasicClient.listPersons();
        List<Person> people = personService.batchAddPersons(personRows);

        // 初始化卡片数据
        cardService.batchAddCards(people);

        // 初始化权限组数据
        permissionGroupService.batchAddPermissionGroups();
    }
}