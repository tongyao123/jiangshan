package com.example.jiangshan.service.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jiangshan.controller.param.DeviceAddGroupParam;
import com.example.jiangshan.controller.param.PermissionGroupAddParam;
import com.example.jiangshan.controller.param.PermissionGroupIdParam;
import com.example.jiangshan.controller.param.PersonAddGroupParam;
import com.example.jiangshan.controller.vo.PermissionGroupVO;
import com.example.jiangshan.client.OpenAccessClient;
import com.example.jiangshan.client.response.GroupDevicePageResponse;
import com.example.jiangshan.client.response.GroupPersonPageResponse;
import com.example.jiangshan.client.response.PermissionGroupPageResponse;
import com.example.jiangshan.client.response.PermissionGroupResponse;
import com.example.jiangshan.constant.ExceptionEnum;
import com.example.jiangshan.mapper.domain.AccessPermissionGroupMapper;
import com.example.jiangshan.mapper.domain.DevicePermissionGroupRelMapper;
import com.example.jiangshan.mapper.domain.PersonPermissionGroupRelMapper;
import com.example.jiangshan.entity.AccessPermissionGroup;
import com.example.jiangshan.entity.DevicePermissionGroupRel;
import com.example.jiangshan.entity.PersonPermissionGroupRel;
import com.example.jiangshan.util.Assert;
import com.example.jiangshan.util.UuidUtil;

/**
 * @author yanyuechao
 * @date 2020-05-20 11:39
 **/
@Service
public class PermissionGroupService {


    private OpenAccessClient openAccessClient;


    private AccessPermissionGroupMapper permissionGroupMapper;


    private DevicePermissionGroupRelMapper devicePermissionGroupMapper;


    private PersonPermissionGroupRelMapper personPermissionGroupMapper;

    public void addPermissionGroup(PermissionGroupAddParam permissionGroupAddParam) {

        PermissionGroupResponse.PermissionGroupData permissionGroupResponse = openAccessClient
                .addPermissionGroup(permissionGroupAddParam);
        permissionGroupMapper.insertSelective(toPermissionGroup(permissionGroupResponse));
    }

    private AccessPermissionGroup toPermissionGroup(
            PermissionGroupResponse.PermissionGroupData permissionGroupResponse) {

        AccessPermissionGroup permissionGroup = new AccessPermissionGroup();
        permissionGroup.setId(UuidUtil.create());
        permissionGroup.setHikPermissionGroupId(permissionGroupResponse.getGroupId());
        permissionGroup.setPermissionGroupName(permissionGroupResponse.getGroupName());
        return permissionGroup;
    }

    public void addDevices(DeviceAddGroupParam deviceAddGroupParam) {

        AccessPermissionGroup permissionGroup = permissionGroupMapper.selectByPrimaryKey(deviceAddGroupParam
                .getGroupId());
        Assert.isTrue(permissionGroup!=null, ExceptionEnum.PERMISSION_GROUP_NOT_EXIST);

        List<DevicePermissionGroupRel> devicePermissionGroupRels = devicePermissionGroupMapper
                .listPermissionGroupDevicesBySerial(permissionGroup.getId(), deviceAddGroupParam.getDeviceSerial());
        Assert.isTrue(CollectionUtils.isEmpty(devicePermissionGroupRels),
                ExceptionEnum.PERMISSION_GROUP_DEVICE_EXIST);

        openAccessClient.addDevices2PermissionGroup(deviceAddGroupParam,permissionGroup.getHikPermissionGroupId());
        DevicePermissionGroupRel devicePermissionGroupRel = new DevicePermissionGroupRel();
        devicePermissionGroupRel.setId(UuidUtil.create());
        devicePermissionGroupRel.setDeviceSerial(deviceAddGroupParam.getDeviceSerial());
        devicePermissionGroupRel.setPermissionGroupId(deviceAddGroupParam.getGroupId());
        devicePermissionGroupMapper.insertSelective(devicePermissionGroupRel);
    }

    public void addPersons(PersonAddGroupParam personAddGroupParam) {

        AccessPermissionGroup permissionGroup = permissionGroupMapper.selectByPrimaryKey(personAddGroupParam
                .getGroupId());
        Assert.isTrue(permissionGroup!=null, ExceptionEnum.PERMISSION_GROUP_NOT_EXIST);

        List<DevicePermissionGroupRel> devicePermissionGroupRels = personPermissionGroupMapper
                .listPermissionGroupPersonsByNo(permissionGroup.getId(), personAddGroupParam.getEmployeeNo());
        Assert.isTrue(CollectionUtils.isEmpty(devicePermissionGroupRels), ExceptionEnum.PERMISSION_GROUP_PERSON_EXIST);

        openAccessClient.addPersons2PermissionGroup(personAddGroupParam,permissionGroup.getHikPermissionGroupId());
        PersonPermissionGroupRel personPermissionGroupRel = new PersonPermissionGroupRel();
        personPermissionGroupRel.setId(UuidUtil.create());
        personPermissionGroupRel.setEmployeeNo(personAddGroupParam.getEmployeeNo());
        personPermissionGroupRel.setPermissionGroupId(personAddGroupParam.getGroupId());
        personPermissionGroupMapper.insertSelective(personPermissionGroupRel);
    }

    public List<PermissionGroupVO> listPermissionGroups() {

        List<AccessPermissionGroup> accessPermissionGroups = permissionGroupMapper.listPermissionGroups();
        return accessPermissionGroups.stream().map(permissionGroup -> {
            PermissionGroupVO permissionGroupVO = new PermissionGroupVO();
            permissionGroupVO.setGroupId(permissionGroup.getId());
            permissionGroupVO.setGroupName(permissionGroup.getPermissionGroupName());

            List<PersonPermissionGroupRel> personPermissionGroupRels = personPermissionGroupMapper
                    .listPermissionGroupPersons(permissionGroup.getId());
            permissionGroupVO.setEmployeeNos(personPermissionGroupRels.stream()
                    .map(PersonPermissionGroupRel::getEmployeeNo)
                    .collect(Collectors.toList()));
            List<DevicePermissionGroupRel> devicePermissionGroupRels = devicePermissionGroupMapper
                    .listPermissionGroupDevices(permissionGroup.getId());
            permissionGroupVO.setDeviceSerials(devicePermissionGroupRels.stream()
                    .map(DevicePermissionGroupRel::getDeviceSerial)
                    .collect(Collectors.toList()));
            return permissionGroupVO;
        }).collect(Collectors.toList());
    }

    public void issuePermission(PermissionGroupIdParam permissionGroupIdParam) {

        AccessPermissionGroup permissionGroup = permissionGroupMapper.selectByPrimaryKey(permissionGroupIdParam
                .getGroupId());
        Assert.isTrue(permissionGroup != null, ExceptionEnum.PERMISSION_GROUP_NOT_EXIST);
        openAccessClient.issuePermission(permissionGroup);
    }

    public void batchAddPermissionGroups() {

        List<PermissionGroupPageResponse.PermissionGroupPage.PermissionGroupRow> permissionGroupRows = openAccessClient
                .listPermissionGroups();
        if (CollectionUtils.isEmpty(permissionGroupRows)) {
            return;
        }
        List<AccessPermissionGroup> accessPermissionGroups = permissionGroupRows.stream()
                .map(permissionGroupRow -> new AccessPermissionGroup(UuidUtil.create(), permissionGroupRow.getGroupId(),
                        permissionGroupRow.getGroupName()))
                .collect(Collectors.toList());
        permissionGroupMapper.batchInsert(accessPermissionGroups);

        accessPermissionGroups.forEach(accessPermissionGroup -> {
            List<GroupPersonPageResponse.GroupPersonPage.GroupPersonRow> personRows = openAccessClient
                    .listGroupPersons(accessPermissionGroup.getHikPermissionGroupId());
            if (CollectionUtils.isNotEmpty(personRows)) {
                personPermissionGroupMapper
                        .batchInsert(toPersonPermissionGroup(accessPermissionGroup.getId(), personRows));
            }
            List<GroupDevicePageResponse.GroupDevicePage.GroupPersonRow> deviceRows = openAccessClient
                    .listGroupDevices(accessPermissionGroup.getHikPermissionGroupId());
            if (CollectionUtils.isNotEmpty(deviceRows)) {
                devicePermissionGroupMapper.batchInsert(
                        toDevicePermissionGroup(accessPermissionGroup.getId(), deviceRows));

            }
        });
    }

    private List<DevicePermissionGroupRel> toDevicePermissionGroup(String groupId,
            List<GroupDevicePageResponse.GroupDevicePage.GroupPersonRow> deviceRows) {

        return deviceRows.stream().map(deviceRow -> new DevicePermissionGroupRel(UuidUtil.create(), groupId,
                deviceRow.getDeviceSerial())).collect(Collectors.toList());
    }

    private List<PersonPermissionGroupRel> toPersonPermissionGroup(String groupId,
            List<GroupPersonPageResponse.GroupPersonPage.GroupPersonRow> personRows) {

        return personRows.stream().map(personRow -> new PersonPermissionGroupRel(UuidUtil.create(), groupId, personRow
                .getEmployeeNo())).collect(Collectors.toList());
    }
}
