package com.example.usercenter.model;

import com.example.net.BaseEntity;
import com.example.net.RetrofitFactory;
import com.example.usercenter.model.api.UserCenterApi;
import com.example.usercenter.model.api.bean.LoginBean;
import com.example.usercenter.model.api.bean.UserBody;

import core.IModel;
import io.reactivex.Flowable;

public class UserModel implements IModel {
    //注册
    public Flowable<BaseEntity<Boolean>> register( UserBody body){
        return RetrofitFactory.INSTANCE.create(UserCenterApi.class).register(body);
    }
    //登录
    public Flowable<BaseEntity<LoginBean>> login( UserBody body){
        return RetrofitFactory.INSTANCE.create(UserCenterApi.class).login(body);
    }
    //获取验证码
    public Flowable<BaseEntity<Boolean>> verificationCode(String phoneNumber){
        return RetrofitFactory.INSTANCE.create(UserCenterApi.class).verificationCode(phoneNumber);
    }
}
