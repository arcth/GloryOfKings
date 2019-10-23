package com.athlete.ranking.domain;

import java.util.Date;

public class WxUser {
    private  int id;
    private  String openid;
    private  String avatarurl;
    private  String province;
    private  String city;
    private  int    gender;
    private  String language;
    private  Date   ctime;
    private  String country;
    private  String nickname;
    private  Date   logintime;
    private  String mobile;
    private  String telnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", avatarurl='" + avatarurl + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                ", language='" + language + '\'' +
                ", ctime=" + ctime +
                ", country='" + country + '\'' +
                ", nickname='" + nickname + '\'' +
                ", logintime=" + logintime +
                ", mobile='" + mobile + '\'' +
                ", telnum='" + telnum + '\'' +
                '}';
    }
}
