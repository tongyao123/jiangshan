package com.example.jiangshan.entity;

import lombok.Data;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table person
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class Person {
    /**
     */
    private String id;

    /**
     */
    private String employeeNo;

    /**
     */
    private String name;

    /**
     */
    private String faceUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.id
     *
     * @return the value of person.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.id
     *
     * @param id the value for person.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.employee_no
     *
     * @return the value of person.employee_no
     *
     * @mbg.generated
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.employee_no
     *
     * @param employeeNo the value for person.employee_no
     *
     * @mbg.generated
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.name
     *
     * @return the value of person.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.name
     *
     * @param name the value for person.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.face_url
     *
     * @return the value of person.face_url
     *
     * @mbg.generated
     */
    public String getFaceUrl() {
        return faceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.face_url
     *
     * @param faceUrl the value for person.face_url
     *
     * @mbg.generated
     */
    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public static final class aBuilder {
        private String id;
        private String employeeNo;
        private String name;
        private String faceUrl;

        private aBuilder() {
        }

        public static aBuilder aPerson() {
            return new aBuilder();
        }

        public aBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public aBuilder setEmployeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
            return this;
        }

        public aBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public aBuilder setFaceUrl(String faceUrl) {
            this.faceUrl = faceUrl;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.setId(id);
            person.setEmployeeNo(employeeNo);
            person.setName(name);
            person.setFaceUrl(faceUrl);
            return person;
        }
    }
}