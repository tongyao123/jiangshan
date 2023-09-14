package com.example.jiangshan.open.client.response;

import lombok.Data;
import lombok.ToString;

/**
 * @author yanyuechao
 * @date 2020-05-20 10:20
 **/
@Data
@ToString(callSuper =true)
public class PersonResponse extends BasicResponse {

    private PersonData data;

    @Data
    public static class PersonData {
        private String employeeNo;
        private String personName;
        private String personPhone;
        private String faceUrl;
        private String personType;
        private Integer floorNo;
        private Integer roomNo;
        private String validBeginTime;
        private String validEndTime;
    }
}
