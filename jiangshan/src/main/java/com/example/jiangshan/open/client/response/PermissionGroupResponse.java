package com.example.jiangshan.open.client.response;

import lombok.Data;
import lombok.ToString;

/**
 * @author yanyuechao
 * @date 2020-05-20 12:27
 **/
@Data
@ToString(callSuper =true)
public class PermissionGroupResponse extends BasicResponse{

    private PermissionGroupData data;
    @Data
    public static class PermissionGroupData {
        private String groupId;
        private String groupName;
    }
}
