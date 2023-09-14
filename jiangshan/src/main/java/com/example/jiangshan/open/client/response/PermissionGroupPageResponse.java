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
public class PermissionGroupPageResponse extends BasicResponse {

    private PermissionGroupPage data;

    @Data
    public static class PermissionGroupPage {
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<PermissionGroupRow> rows;

        @Data
        public static class PermissionGroupRow {
            private String groupId;
            private String groupName;
            private String createTime;
            private String updateTime;
        }

    }
}
