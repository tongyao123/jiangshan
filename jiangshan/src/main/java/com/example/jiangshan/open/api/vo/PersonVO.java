package com.example.jiangshan.open.api.vo;

import lombok.Data;

/**
 * @author yanyuechao
 * @date 2020-05-20 11:06
 **/
@Data
public class PersonVO {

    /**
     * employeeNo :
     * personName :
     * faceUrl :
     * cardNo :
     */
    private String employeeNo;
    private String personName;
    private String faceUrl;
    private String cardNo;

    public static final class aBuilder {
        private String employeeNo;
        private String personName;
        private String faceUrl;
        private String cardNo;

        private aBuilder() {
        }

        public static aBuilder aPersonVO() {
            return new aBuilder();
        }

        public aBuilder setEmployeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
            return this;
        }

        public aBuilder setPersonName(String personName) {
            this.personName = personName;
            return this;
        }

        public aBuilder setFaceUrl(String faceUrl) {
            this.faceUrl = faceUrl;
            return this;
        }

        public aBuilder setCardNo(String cardNo) {
            this.cardNo = cardNo;
            return this;
        }

        public PersonVO build() {
            PersonVO personVO = new PersonVO();
            personVO.setEmployeeNo(employeeNo);
            personVO.setPersonName(personName);
            personVO.setFaceUrl(faceUrl);
            personVO.setCardNo(cardNo);
            return personVO;
        }
    }
}
