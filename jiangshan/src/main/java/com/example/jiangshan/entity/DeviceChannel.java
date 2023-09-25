package com.example.jiangshan.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table device_channel
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class DeviceChannel {

    private String channelId;
    private String channelName;
    private String channelType;
    private Integer channelNo;
    private Integer channelStatus;
    private String deviceSerial;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_channel.channel_id
     *
     * @return the value of device_channel.channel_id
     *
     * @mbg.generated
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_channel.channel_id
     *
     * @param channelId the value for device_channel.channel_id
     *
     * @mbg.generated
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_channel.channel_name
     *
     * @return the value of device_channel.channel_name
     *
     * @mbg.generated
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_channel.channel_name
     *
     * @param channelName the value for device_channel.channel_name
     *
     * @mbg.generated
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_channel.channel_type
     *
     * @return the value of device_channel.channel_type
     *
     * @mbg.generated
     */
    public String getChannelType() {
        return channelType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_channel.channel_type
     *
     * @param channelType the value for device_channel.channel_type
     *
     * @mbg.generated
     */
    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_channel.channel_no
     *
     * @return the value of device_channel.channel_no
     *
     * @mbg.generated
     */
    public Integer getChannelNo() {
        return channelNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_channel.channel_no
     *
     * @param channelNo the value for device_channel.channel_no
     *
     * @mbg.generated
     */
    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_channel.channel_status
     *
     * @return the value of device_channel.channel_status
     *
     * @mbg.generated
     */
    public Integer getChannelStatus() {
        return channelStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_channel.channel_status
     *
     * @param channelStatus the value for device_channel.channel_status
     *
     * @mbg.generated
     */
    public void setChannelStatus(Integer channelStatus) {
        this.channelStatus = channelStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column device_channel.device_serial
     *
     * @return the value of device_channel.device_serial
     *
     * @mbg.generated
     */
    public String getDeviceSerial() {
        return deviceSerial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column device_channel.device_serial
     *
     * @param deviceSerial the value for device_channel.device_serial
     *
     * @mbg.generated
     */
    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public static final class aBuilder {
        private String channelId;
        private String channelName;
        private String channelType;
        private Integer channelNo;
        private Integer channelStatus;
        private String deviceSerial;

        private aBuilder() {
        }

        public static aBuilder aDeviceChannel() {
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

        public DeviceChannel build() {
            DeviceChannel deviceChannel = new DeviceChannel();
            deviceChannel.setChannelId(channelId);
            deviceChannel.setChannelName(channelName);
            deviceChannel.setChannelType(channelType);
            deviceChannel.setChannelNo(channelNo);
            deviceChannel.setChannelStatus(channelStatus);
            deviceChannel.setDeviceSerial(deviceSerial);
            return deviceChannel;
        }
    }
}