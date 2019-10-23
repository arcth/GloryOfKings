package com.athlete.ranking.domain;

import java.util.Date;

public class User {

    private String userHead;
    private String userName;
    private String userGender;
    private Date userNewLogin;
    private String userCity;
    private String userProvince;
    private String userOpenid;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }


    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserProvince() {
        return userProvince;
    }

    public void setUserProvince(String userProvince) {
        this.userProvince = userProvince;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }


    public Date getUserNewLogin() {
        return userNewLogin;
    }

    public void setUserNewLogin(Date userNewLogin) {
        this.userNewLogin = userNewLogin;
    }
}
