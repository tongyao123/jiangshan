package com.example.jiangshan.entity;

public class User {
    private String userId;
    private String name;
    private String password;
    private String type;
    private String phone;
    private String user_wx;

    public String getPhone() {
        return phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_wx() {
        return user_wx;
    }

    public void setUser_wx(String user_wx) {
        this.user_wx = user_wx;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
