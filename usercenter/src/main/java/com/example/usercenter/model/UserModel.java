package com.example.usercenter.model;

import com.example.net.BaseEntity;
import com.example.net.RetrofitFactory;
import com.example.usercenter.model.api.UserCenterApi;
import com.example.usercenter.model.api.bean.AddFriendBean;
import com.example.usercenter.model.api.bean.LoginBean;
import com.example.usercenter.model.api.bean.UserBody;
import com.example.usercenter.model.api.bean.UserInfoBean;

import java.util.List;

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
    //搜索用户
    public Flowable<BaseEntity<List<UserInfoBean>>> searchUser(String username){
        return RetrofitFactory.INSTANCE.create(UserCenterApi.class).searchUser(username);
    }
    //添加用户
    public Flowable<BaseEntity<Boolean>> addUser(AddFriendBean bean){
        return RetrofitFactory.INSTANCE.create(UserCenterApi.class).addUser(bean);
    }
}
