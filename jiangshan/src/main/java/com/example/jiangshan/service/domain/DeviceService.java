package com.example.jiangshan.service.domain;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jiangshan.controller.param.DeviceAddParam;
import com.example.jiangshan.controller.param.DeviceEncryptOffParam;
import com.example.jiangshan.controller.vo.DeviceVO;
import com.example.jiangshan.client.OpenBasicClient;
import com.example.jiangshan.client.response.DevicePageResponse;
import com.example.jiangshan.client.response.DeviceResponse;
import com.example.jiangshan.constant.ExceptionEnum;
import com.example.jiangshan.mapper.domain.DeviceMapper;
import com.example.jiangshan.mapper.domain.GroupMapper;
import com.example.jiangshan.entity.Device;
import com.example.jiangshan.entity.Group;
import com.example.jiangshan.util.Assert;
import com.example.jiangshan.util.UuidUtil;

/**
 * @author yanyuechao
 * @date 2020-05-19 14:27
 **/
@Service
public class DeviceService {
    @Autowired
    private OpenBasicClient openBasicClient;
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private GroupMapper groupMapper;

    public void addDevice(DeviceAddParam deviceAddParam) {

        Group group = groupMapper.selectByPrimaryKey(deviceAddParam.getGroupId());
        Assert.isTrue(group != null, ExceptionEnum.GROUP_NOT_EXIST);

        DeviceResponse.DeviceData deviceResponse = openBasicClient.addDevice(deviceAddParam, group);

        // 保存设备数据
        deviceMapper.insertSelective(getDevice(deviceAddParam, deviceResponse, group));
    }

    public List<DeviceVO> listDevices(String groupId) {

        List<Device> devices;
        if (StringUtils.isBlank(groupId)) {
            devices = deviceMapper.listDevices();
        } else {
            devices = deviceMapper.listDevicesByGroupId(groupId);
        }
        return toDeviceVO(devices);
    }

    public void encryptOff(DeviceEncryptOffParam param) {
        openBasicClient.encryptOff(param);
    }

    private Device getDevice(DeviceAddParam deviceAddParam, DeviceResponse.DeviceData deviceResponse, Group group) {

        Device device = new Device();
        device.setDeviceId(UuidUtil.create());
        device.setValidateCode(deviceAddParam.getValidateCode());
        device.setDeviceSerial(deviceAddParam.getDeviceSerial());
        device.setDeviceModel(deviceResponse.getDeviceModel());
        device.setDeviceStatus(String.valueOf(deviceResponse.getDeviceStatus()));
        device.setGroupId(group.getGroupId());
        device.setCreateTime(new Date());
        return device;
    }

    private List<DeviceVO> toDeviceVO(List<Device> devices) {
        return devices.stream().map(device -> {
            Group group = groupMapper.selectByPrimaryKey(device.getGroupId());
            return DeviceVO.aBuilder.aDeviceVO().setDeviceId(device.getDeviceId())
                    .setDeviceSerial(device.getDeviceSerial())
                        .setDeviceModel(device.getDeviceModel()).setDeviceStatus(device.getDeviceStatus()).setCreateTime
                    (device.getCreateTime()).setGroupName(group != null ? group.getGroupName() : "").build();
        })
                .collect(Collectors.toList());
    }

    public void batchAddDevices(List<DevicePageResponse.DevicePage.DeviceRow> deviceRows) {
        if(CollectionUtils.isNotEmpty(deviceRows)) {
            List<Device> devices = deviceRows.stream().map(deviceRow -> Device.aBuilder.aDevice().setDeviceId(deviceRow.getDeviceId())
                    .setDeviceName(deviceRow.getDeviceName()).setDeviceModel(deviceRow.getDeviceModel()).setDeviceSerial
                            (deviceRow.getDeviceSerial()).setDeviceStatus(String.valueOf(deviceRow.getDeviceStatus()))
                    .setGroupId(deviceRow.getGroupId()).setCreateTime(new Date()).build()).collect(Collectors.toList());
            deviceMapper.batchInsert(devices);
        }

    }
}
