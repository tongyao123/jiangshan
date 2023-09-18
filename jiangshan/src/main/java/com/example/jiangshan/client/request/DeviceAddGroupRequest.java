package com.example.jiangshan.client.request;
import java.util.List;
import lombok.Data;

/**
 * @author yanyuechao
 * @date 2020-05-20 17:03
 **/
@Data
public class DeviceAddGroupRequest {

    private String groupId;
    private List<String> deviceSerials;
}
