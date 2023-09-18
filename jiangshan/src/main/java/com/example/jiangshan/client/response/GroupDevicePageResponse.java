package com.example.jiangshan.client.response;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * @author yanyuechao
 * @date 2020-05-19 19:06
 **/
@Data
@ToString(callSuper = true)
public class GroupDevicePageResponse extends BasicResponse {

    private GroupDevicePage data;

    @Data
    public static class GroupDevicePage {
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<GroupPersonRow> rows;

        @Data
        public static class GroupPersonRow {
            private String deviceSerial;
            private Boolean hasCapability;
        }
    }
}
