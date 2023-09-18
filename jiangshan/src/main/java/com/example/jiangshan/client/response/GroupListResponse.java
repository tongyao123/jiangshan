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
public class GroupListResponse extends BasicResponse{

    private List<GroupRow> data;

    @Data
    public static class GroupRow {
        private String groupId;
        private String groupName;
        private String groupNo;
        private String parentId;
    }


}
