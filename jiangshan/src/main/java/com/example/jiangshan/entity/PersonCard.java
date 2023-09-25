package com.example.jiangshan.entity;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table person_card
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class PersonCard {
    /**
     * 主键ID(id)
     */
    private String id;

    /**
     */
    private String personId;

    /**
     */
    private String employeeNo;

    /**
     */
    private String cardNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person_card.id
     *
     * @return the value of person_card.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person_card.id
     *
     * @param id the value for person_card.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person_card.person_id
     *
     * @return the value of person_card.person_id
     *
     * @mbg.generated
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person_card.person_id
     *
     * @param personId the value for person_card.person_id
     *
     * @mbg.generated
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person_card.employee_no
     *
     * @return the value of person_card.employee_no
     *
     * @mbg.generated
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person_card.employee_no
     *
     * @param employeeNo the value for person_card.employee_no
     *
     * @mbg.generated
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person_card.card_no
     *
     * @return the value of person_card.card_no
     *
     * @mbg.generated
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person_card.card_no
     *
     * @param cardNo the value for person_card.card_no
     *
     * @mbg.generated
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public static final class aBuilder {
        private String id;
        private String personId;
        private String employeeNo;
        private String cardNo;

        private aBuilder() {
        }

        public static aBuilder aPersonCard() {
            return new aBuilder();
        }

        public aBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public aBuilder setPersonId(String personId) {
            this.personId = personId;
            return this;
        }

        public aBuilder setEmployeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
            return this;
        }

        public aBuilder setCardNo(String cardNo) {
            this.cardNo = cardNo;
            return this;
        }

        public PersonCard build() {
            PersonCard personCard = new PersonCard();
            personCard.setId(id);
            personCard.setPersonId(personId);
            personCard.setEmployeeNo(employeeNo);
            personCard.setCardNo(cardNo);
            return personCard;
        }
    }
}