package com.example.jiangshan.open.client.response;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * @author yanyuechao
 * @date 2020-05-19 19:06
 **/
@Data
@ToString(callSuper = true)
public class GroupPersonPageResponse extends BasicResponse {

    private GroupPersonPage data;

    @Data
    public static class GroupPersonPage {
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<GroupPersonRow> rows;

        @Data
        public static class GroupPersonRow {
            private String employeeNo;
        }
    }
}
