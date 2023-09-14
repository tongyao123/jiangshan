package com.example.jiangshan.open.api.vo;

import java.util.Date;

import lombok.Data;

/**
 * @author yanyuechao
 * @date 2020-05-19 16:41
 **/
@Data
public class DeviceVO {
    private String deviceId;
    private String deviceSerial;
    private String deviceModel;
    private String deviceStatus;
    private String groupName;
    private Date createTime;

    public static final class aBuilder {
        private String deviceId;
        private String deviceSerial;
        private String deviceModel;
        private String deviceStatus;
        private String groupName;
        private Date createTime;

        private aBuilder() {
        }

        public static aBuilder aDeviceVO() {
            return new aBuilder();
        }

        public aBuilder setDeviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public aBuilder setDeviceSerial(String deviceSerial) {
            this.deviceSerial = deviceSerial;
            return this;
        }

        public aBuilder setDeviceModel(String deviceModel) {
            this.deviceModel = deviceModel;
            return this;
        }

        public aBuilder setDeviceStatus(String deviceStatus) {
            this.deviceStatus = deviceStatus;
            return this;
        }

        public aBuilder setGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public aBuilder setCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public DeviceVO build() {
            DeviceVO deviceVO = new DeviceVO();
            deviceVO.setDeviceId(deviceId);
            deviceVO.setDeviceSerial(deviceSerial);
            deviceVO.setDeviceModel(deviceModel);
            deviceVO.setDeviceStatus(deviceStatus);
            deviceVO.setGroupName(groupName);
            deviceVO.setCreateTime(createTime);
            return deviceVO;
        }
    }
}
