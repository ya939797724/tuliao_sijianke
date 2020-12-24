package com.example.usercenter.model.api.bean;

public class AddFriendBean {

    /**
     * addtype : 0
     * alias :
     * friendid : 0
     * localgroupid : 0
     * userid : 0
     */

    private Integer addtype;
    private String alias;
    private Integer friendid;
    private Integer localgroupid;
    private Integer userid;

    @Override
    public String toString() {
        return "AddFriendBean{" +
                "addtype=" + addtype +
                ", alias='" + alias + '\'' +
                ", friendid=" + friendid +
                ", localgroupid=" + localgroupid +
                ", userid=" + userid +
                '}';
    }

    public AddFriendBean() {
    }

    public Integer getAddtype() {
        return addtype;
    }

    public void setAddtype(Integer addtype) {
        this.addtype = addtype;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }

    public Integer getLocalgroupid() {
        return localgroupid;
    }

    public void setLocalgroupid(Integer localgroupid) {
        this.localgroupid = localgroupid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public AddFriendBean(Integer addtype, String alias, Integer friendid, Integer localgroupid, Integer userid) {
        this.addtype = addtype;
        this.alias = alias;
        this.friendid = friendid;
        this.localgroupid = localgroupid;
        this.userid = userid;
    }
}
