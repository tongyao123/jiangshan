package com.example.jiangshan.client.request;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanyuechao
 * @date 2020-05-19 10:41
 **/
@Data
@NoArgsConstructor
public class GroupAddRequest {

    private String groupName;
    private String groupNo;
    private String parentNo;
    public GroupAddRequest(String groupName, String groupNo, String parentNo) {
        this.groupName = groupName;
        this.groupNo = groupNo;
        this.parentNo = parentNo;
    }
}
