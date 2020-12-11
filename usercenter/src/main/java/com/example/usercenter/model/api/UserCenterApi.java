package com.example.usercenter.model.api;

import com.example.net.BaseEntity;
import com.example.usercenter.model.api.bean.LoginBean;
import com.example.usercenter.model.api.bean.UserBody;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserCenterApi {
    @POST("/gisim/user/register")
    Flowable<BaseEntity<Boolean>> register(@Body UserBody body);
    @POST("/gisim/user/login")
    Flowable<BaseEntity<LoginBean>> login(@Body UserBody body);
}
