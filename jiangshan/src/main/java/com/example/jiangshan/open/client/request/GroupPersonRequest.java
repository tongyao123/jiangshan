package com.example.jiangshan.open.client.request;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanyuechao
 * @date 2020-06-09 17:22
 **/
@Data
@NoArgsConstructor
public class GroupPersonRequest extends PageRequest {
    private String groupId;

    public GroupPersonRequest(String groupId, Integer pageNo, Integer pageSize) {
        super(pageNo, pageSize);
        this.groupId = groupId;
    }
}
