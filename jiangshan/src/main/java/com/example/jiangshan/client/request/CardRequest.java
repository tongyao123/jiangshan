package com.example.jiangshan.client.request;

import java.util.List;

import lombok.Data;

/**
 * @author yanyuechao
 * @date 2020-05-20 10:49
 **/
@Data
public class CardRequest {

    private List<CardsBean> cards;

    @Data
    public static class CardsBean {
        /**
         * cardNo : gfdgdfgd
         * cardType : normalCard
         * employeeNo : 321
         */
        private String cardNo;
        private String cardType;
        private String employeeNo;
    }
}
