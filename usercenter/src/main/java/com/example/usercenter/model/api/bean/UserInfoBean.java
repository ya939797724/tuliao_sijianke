package com.example.usercenter.model.api.bean;

public class UserInfoBean {
    private Integer id;
    private String phonenumber;
    private String nick;
    private String headimg;
    private String imaccount;
    private String token;
    private String lon;
    private String lat;

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "id=" + id +
                ", phonenumber='" + phonenumber + '\'' +
                ", nick='" + nick + '\'' +
                ", headimg='" + headimg + '\'' +
                ", imaccount='" + imaccount + '\'' +
                ", token='" + token + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }

    public UserInfoBean() {
    }

    public UserInfoBean(Integer id, String phonenumber, String nick, String headimg, String imaccount, String token, String lon, String lat) {
        this.id = id;
        this.phonenumber = phonenumber;
        this.nick = nick;
        this.headimg = headimg;
        this.imaccount = imaccount;
        this.token = token;
        this.lon = lon;
        this.lat = lat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getImaccount() {
        return imaccount;
    }

    public void setImaccount(String imaccount) {
        this.imaccount = imaccount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
