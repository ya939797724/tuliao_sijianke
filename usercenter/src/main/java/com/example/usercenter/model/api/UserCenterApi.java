package com.example.usercenter.model.api;

import com.example.net.BaseEntity;
import com.example.usercenter.model.api.bean.LoginBean;
import com.example.usercenter.model.api.bean.UserBody;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserCenterApi {
    //注册
    @POST("/gisim/user/register")
    Flowable<BaseEntity<Boolean>> register(@Body UserBody body);
    //登录
    @POST("/gisim/user/login")
    Flowable<BaseEntity<LoginBean>> login(@Body UserBody body);
    //获取验证码
    @GET("/gisim/user/verificationCode")
    Flowable<BaseEntity<Boolean>> verificationCode(String phoneNumber);
}
