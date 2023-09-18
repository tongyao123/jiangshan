package com.example.jiangshan.client.response;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * @author yanyuechao
 * @date 2020-05-19 19:06
 **/
@Data
@ToString(callSuper =true)
public class DevicePageResponse extends BasicResponse{

    private DevicePage data;

    @Data
    public static class DevicePage {
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<DeviceRow> rows;

        @Data
        public static class DeviceRow {
            private String deviceId;
            private String deviceName;
            private String deviceModel;
            private String deviceSerial;
            private Integer deviceStatus;
            private String groupId;
        }

    }
}
