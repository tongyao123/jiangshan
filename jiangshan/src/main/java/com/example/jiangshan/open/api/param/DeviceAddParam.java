package com.example.jiangshan.open.api.param;

import lombok.Data;

/**
 * @author yanyuechao
 * @date 2020-05-19 14:26
 **/
@Data
public class DeviceAddParam {

    private String groupId;
    private String deviceSerial;
    private String validateCode;
}
