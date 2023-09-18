package com.example.jiangshan.client;

import java.util.List;

import com.example.jiangshan.client.request.*;
import com.example.jiangshan.client.response.*;
import com.example.jiangshan.client.response.PermissionGroupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;
import com.example.jiangshan.controller.param.DeviceAddGroupParam;
import com.example.jiangshan.controller.param.PermissionGroupAddParam;
import com.example.jiangshan.controller.param.PersonAddGroupParam;
import com.example.jiangshan.constant.ExceptionEnum;
import com.example.jiangshan.entity.AccessPermissionGroup;
import com.example.jiangshan.util.Assert;
import com.example.jiangshan.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanyuechao
 * @date 2020-05-18 19:09
 **/
@Slf4j
@Component
public class OpenAccessClient extends BasicClient {

    private static final String OPEN_ACCESSCONTROL_GROUP_ADD = "/api/v1/open/accessControl/permissionGroups/create";

    private static final String OPEN_ACCESSCONTROL_DEVICE_ADD = "/api/v1/open/accessControl/permissionGroups/actions/addDevices";

    private static final String OPEN_ACCESSCONTROL_PERSON_ADD =
            "/api/v1/open/accessControl/permissionGroups/actions/addPersons";

    private static final String OPEN_ACCESSCONTROL_ISSUED_PERMISSION = "/api/v1/open/accessControl/allots/actions/issuedByGroup";

    private static final String OPEN_ACCESSCONTROL_GROUP_LIST = "/api/v1/open/accessControl/permissionGroups/actions/page";

    private static final String OPEN_ACCESSCONTROL_GROUP_EMPLOYEE_LIST = "/api/v1/open/accessControl/permissionGroups/actions/getEmployeeNos";

    private static final String OPEN_ACCESSCONTROL_GROUP_DEVICE_LIST = "/api/v1/open/accessControl/permissionGroups/actions/getDeviceSerials";

    @Value("${OPEN_URL}")
    private String host;
    @Autowired
    private RestTemplate openRestTemplate;

    public PermissionGroupResponse.PermissionGroupData addPermissionGroup(PermissionGroupAddParam groupAddParam) {

        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(groupAddParam), getHttpHeaders());
        PermissionGroupResponse openResult = openRestTemplate.postForObject
                (host+OPEN_ACCESSCONTROL_GROUP_ADD,
                request, PermissionGroupResponse.class);
        log.info("addPermissionGroup,groupAddParam:{} openResult:{}", groupAddParam, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), openResult, ExceptionEnum.PERMISSION_GROUP_ADD_ERROR);
        return openResult.getData();
    }

    public void addDevices2PermissionGroup(DeviceAddGroupParam deviceAddGroupParam, String hikGroupId) {

        DeviceAddGroupRequest deviceAddGroup = new DeviceAddGroupRequest();
        deviceAddGroup.setDeviceSerials(Lists.newArrayList(deviceAddGroupParam.getDeviceSerial()));
        deviceAddGroup.setGroupId(hikGroupId);

        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(deviceAddGroup), getHttpHeaders());
        BasicResponse openResult = openRestTemplate.postForObject(host + OPEN_ACCESSCONTROL_DEVICE_ADD, request,
                BasicResponse.class);
        log.info("addDevices2PermissionGroup,deviceAddGroupParam:{} openResult:{}", deviceAddGroupParam, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), openResult, ExceptionEnum.PERMISSION_GROUP_ADD_DEVICE_ERROR);
    }


    public void addPersons2PermissionGroup(PersonAddGroupParam personAddGroupParam, String hikGroupId) {

        PersonAddGroupRequest personAddGroupRequest = new PersonAddGroupRequest();
        personAddGroupRequest.setEmployeeNos(Lists.newArrayList(personAddGroupParam.getEmployeeNo()));
        personAddGroupRequest.setGroupId(hikGroupId);
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(personAddGroupRequest), getHttpHeaders());
        BasicResponse openResult = openRestTemplate.postForObject(host + OPEN_ACCESSCONTROL_PERSON_ADD,
                request, BasicResponse.class);
        log.info("addPersons2PermissionGroup,personAddGroupParam:{} openResult:{}", personAddGroupParam, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), openResult, ExceptionEnum.PERMISSION_GROUP_ADD_PERSON_ERROR);
    }

    public void issuePermission(AccessPermissionGroup permissionGroup) {

        PermissionGroupIdRequest permissionGroupIdRequest = new PermissionGroupIdRequest();
        permissionGroupIdRequest.setGroupId(permissionGroup.getHikPermissionGroupId());
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(permissionGroupIdRequest), getHttpHeaders());
        BasicResponse openResult = openRestTemplate.postForObject(host + OPEN_ACCESSCONTROL_ISSUED_PERMISSION, request,
                BasicResponse.class);
        log.info("issuePermission,permissionGroupIdRequest:{} openResult:{}", permissionGroupIdRequest, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), openResult, ExceptionEnum.PERMISSION_ISSUE_ERROR);
    }

    public List<PermissionGroupPageResponse.PermissionGroupPage.PermissionGroupRow> listPermissionGroups() {

        PageRequest pageRequest = new PageRequest(1, 10);
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(pageRequest), getHttpHeaders());
        PermissionGroupPageResponse openResult = openRestTemplate.postForObject(host + OPEN_ACCESSCONTROL_GROUP_LIST,
                request,
                PermissionGroupPageResponse.class);
        log.info("listPermissionGroups: basicResponse:{}", openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), ExceptionEnum.GET_DATA_ERROR);
        PermissionGroupPageResponse.PermissionGroupPage data = openResult.getData();
        return data.getRows();
    }

    public List<GroupPersonPageResponse.GroupPersonPage.GroupPersonRow> listGroupPersons(String groupId) {

        GroupPersonRequest groupPersonRequest = new GroupPersonRequest(groupId, 1, 100);
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(groupPersonRequest), getHttpHeaders());
        GroupPersonPageResponse openResult = openRestTemplate.postForObject(
                host + OPEN_ACCESSCONTROL_GROUP_EMPLOYEE_LIST,
                request, GroupPersonPageResponse.class);
        log.info("listGroupPersons,groupNo:{} basicResponse:{}", openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), ExceptionEnum.GET_DATA_ERROR);
        GroupPersonPageResponse.GroupPersonPage data = openResult.getData();
        return data.getRows();
    }

    public List<GroupDevicePageResponse.GroupDevicePage.GroupPersonRow> listGroupDevices(String groupId) {

        GroupPersonRequest groupPersonRequest = new GroupPersonRequest(groupId, 1, 100);
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(groupPersonRequest), getHttpHeaders());
        GroupDevicePageResponse openResult = openRestTemplate.postForObject(host + OPEN_ACCESSCONTROL_GROUP_DEVICE_LIST,
                request, GroupDevicePageResponse.class);
        log.info("listGroupDevices,groupNo:{} basicResponse:{}", openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), ExceptionEnum.GET_DATA_ERROR);
        GroupDevicePageResponse.GroupDevicePage data = openResult.getData();
        return data.getRows();
    }

}