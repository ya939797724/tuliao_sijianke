package com.example.usercenter.ui.adduser.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

public class CusTabEntity implements CustomTabEntity {
    private String title;
    private int selecticon;
    private int unselecticon;

    public CusTabEntity(String title, int selecticon, int unselecticon) {
        this.title = title;
        this.selecticon = selecticon;
        this.unselecticon = unselecticon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selecticon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselecticon;
    }
}
