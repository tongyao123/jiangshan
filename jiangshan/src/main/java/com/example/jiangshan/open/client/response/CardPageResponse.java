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
public class CardPageResponse extends BasicResponse{

    private CardPage data;
    @Data
    public static class CardPage {
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<CardRow> rows;

        @Data
        public static class CardRow {
            private String cardNo;
            private String employeeNo;
            private String cardType;
        }

    }
}
