package com.example.jiangshan.client.response;

import lombok.Data;
import lombok.ToString;

/**
 * @author yanyuechao
 * @date 2020-05-19 14:41
 **/
@Data
@ToString(callSuper =true)
public class DeviceResponse extends BasicResponse {

    private DeviceData data;

    @Data
    public static class DeviceData {
        private String deviceId;
        private String deviceName;
        private String deviceModel;
        private String deviceSerial;
        private Integer deviceStatus;
        private String groupId;
    }
}
