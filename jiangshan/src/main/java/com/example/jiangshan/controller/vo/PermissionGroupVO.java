package com.example.jiangshan.controller.vo;

import java.util.List;

import lombok.Data;

/**
 * @author yanyuechao
 * @date 2020-05-21 10:12
 **/
@Data
public class PermissionGroupVO {

    private String groupId;
    private String groupName;
    private List<String> employeeNos;
    private List<String> deviceSerials;
}
