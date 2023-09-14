package com.example.jiangshan.open.client.request;

import java.util.List;

import lombok.Data;

/**
 * @author yanyuechao
 * @date 2020-05-20 17:03
 **/
@Data
public class PersonAddGroupRequest {

    private String groupId;
    private List<String> employeeNos;
}
