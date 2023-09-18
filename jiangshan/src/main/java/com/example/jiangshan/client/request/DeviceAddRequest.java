package com.example.jiangshan.client.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceAddRequest {

    private String groupNo;
    private String deviceSerial;
    private String validateCode;

    public DeviceAddRequest(String groupNo, String deviceSerial, String validateCode) {
        this.groupNo = groupNo;
        this.deviceSerial = deviceSerial;
        this.validateCode = validateCode;
    }
}
