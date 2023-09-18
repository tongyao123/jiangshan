package com.example.jiangshan.controller.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanyuechao
 * @date 2020-05-19 14:19
 **/
@Data
@NoArgsConstructor
public class GroupVO {

    private String groupId;
    private String groupName;

    public GroupVO(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }
}
