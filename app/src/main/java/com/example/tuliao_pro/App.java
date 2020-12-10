package com.example.tuliao_pro;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 在此处调用基础组件包提供的初始化函数 相应信息可在应用管理 -> 应用信息 中找到 http://message.umeng.com/list/apps
        // 参数一：当前上下文context；
        // 参数二：应用申请的Appkey（需替换）；
        // 参数三：渠道名称；
        // 参数四：设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure.DEVICE_TYPE_BOX则表示盒子；默认为手机；
        // 参数五：Push推送业务的secret 填充Umeng Message Secret对应信息（需替换）
//        UMConfigure.init(this, "5f22326518f0f154d77f7682", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "8ed5ed6c1612e39e95f650146bac1894");
//
//        //获取消息推送代理示例
//        PushAgent mPushAgent = PushAgent.getInstance(this);
//        //注册推送服务，每次调用register方法都会回调该接口
//        mPushAgent.register(new IUmengRegisterCallback() {
//
//            @Override
//            public void onSuccess(String deviceToken) {
//                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
//                Log.i("====","注册成功：deviceToken：-------->  " + deviceToken);
//            }
//
//            @Override
//            public void onFailure(String s, String s1) {
//                Log.e("====","注册失败：-------->  " + "s:" + s + ",s1:" + s1);
//            }
//        });
    }
}
