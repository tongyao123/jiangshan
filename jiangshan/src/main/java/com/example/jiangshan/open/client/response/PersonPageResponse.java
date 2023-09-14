package com.example.jiangshan.open.client.response;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * @author yanyuechao
 * @date 2020-05-19 19:06
 **/
@Data
@ToString(callSuper =true)
public class PersonPageResponse extends BasicResponse{

    private PersonPage data;

    @Data
    public static class PersonPage {
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<PersonRow> rows;

        @Data
        public static class PersonRow {
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
}
