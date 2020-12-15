package com.example.usercenter.model.api.bean;


public class LoginBean {

    /**
     * id : 19
     * phonenumber : 123
     * nick : null
     * headimg : null
     * imaccount : null
     * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMjMifQ.xKPoMpjMrGHF2iDgqhXrvyypo8HGEZtqDcnND2tQyPo
     */

    private Integer id;
    private String phonenumber;
    private String nick;
    private String headimg;
    private String imaccount;
    private String token;

    @Override
    public String toString() {
        return "LoginBean{" +
                "id=" + id +
                ", phonenumber='" + phonenumber + '\'' +
                ", nick='" + nick + '\'' +
                ", headimg='" + headimg + '\'' +
                ", imaccount='" + imaccount + '\'' +
                ", token='" + token + '\'' +
                '}';
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
}
