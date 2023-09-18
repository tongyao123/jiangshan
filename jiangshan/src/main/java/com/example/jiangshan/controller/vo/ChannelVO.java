package com.example.jiangshan.controller.vo;

import lombok.Data;

/**
 * @author yanyuechao
 * @date 2020-05-26 16:22
 **/
@Data
public class ChannelVO {
    private String channelId;
    private String channelName;
    private String channelType;
    private Integer channelNo;
    private Integer channelStatus;
    private String deviceSerial;

    public static final class aBuilder {
        private String channelId;
        private String channelName;
        private String channelType;
        private Integer channelNo;
        private Integer channelStatus;
        private String deviceSerial;

        private aBuilder() {
        }

        public static aBuilder aChannelVO() {
            return new aBuilder();
        }

        public aBuilder setChannelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        public aBuilder setChannelName(String channelName) {
            this.channelName = channelName;
            return this;
        }

        public aBuilder setChannelType(String channelType) {
            this.channelType = channelType;
            return this;
        }

        public aBuilder setChannelNo(Integer channelNo) {
            this.channelNo = channelNo;
            return this;
        }

        public aBuilder setChannelStatus(Integer channelStatus) {
            this.channelStatus = channelStatus;
            return this;
        }

        public aBuilder setDeviceSerial(String deviceSerial) {
            this.deviceSerial = deviceSerial;
            return this;
        }

        public ChannelVO build() {
            ChannelVO channelVO = new ChannelVO();
            channelVO.setChannelId(channelId);
            channelVO.setChannelName(channelName);
            channelVO.setChannelType(channelType);
            channelVO.setChannelNo(channelNo);
            channelVO.setChannelStatus(channelStatus);
            channelVO.setDeviceSerial(deviceSerial);
            return channelVO;
        }
    }
}
