package com.example.usercenter.model.api.bean;

public class UserBody {

    /**
     * imaccount :
     * phonenumber :
     * pwd :
     */

    private String imaccount;
    private String phonenumber;
    private String pwd;

    @Override
    public String toString() {
        return "UserBody{" +
                "imaccount='" + imaccount + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getImaccount() {
        return imaccount;
    }

    public void setImaccount(String imaccount) {
        this.imaccount = imaccount;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public UserBody(String imaccount, String phonenumber, String pwd) {
        this.imaccount = imaccount;
        this.phonenumber = phonenumber;
        this.pwd = pwd;
    }
}
