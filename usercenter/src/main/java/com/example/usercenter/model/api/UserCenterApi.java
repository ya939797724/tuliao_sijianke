package com.example.usercenter.model.api;

import com.example.net.BaseEntity;
import com.example.usercenter.model.api.bean.AddFriendBean;
import com.example.usercenter.model.api.bean.LoginBean;
import com.example.usercenter.model.api.bean.UserBody;
import com.example.usercenter.model.api.bean.UserInfoBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    //搜索用户
    @GET("/gisim/friend/queryUser")
    Flowable<BaseEntity<List<UserInfoBean>>> searchUser(@Query("keyword") String userName);
    //发送好友申请
    @POST("/gisim/friend/addFriend")
    Flowable<BaseEntity<Boolean>> addUser(@Body AddFriendBean bean);

}
