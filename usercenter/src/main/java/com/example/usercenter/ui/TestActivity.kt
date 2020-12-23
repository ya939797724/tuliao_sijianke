package com.example.usercenter.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ExpandableListAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.common.sp.SPUtil
import com.example.net.RetrofitFactory.create
import com.example.observ.customObserver
import com.example.usercenter.R
import com.example.usercenter.model.api.UserCenterApi
import com.example.usercenter.model.api.bean.UserBody
import kotlinx.android.synthetic.main.activity_test.*

@Route(path = ActivitySwitch.UserCenter.TEST_ACT)
class TestActivity : AppCompatActivity() {
//    var token by SPUtil<String>(this,"userToken","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        ARouter.getInstance().inject(this)
    }

    fun onClick(view: View?) {
//        create(UserCenterApi::class.java)
//            .login(UserBody("123@zhangyue", "123", "123"))
//            .customObserver({
//                token = it.data.token
//                Toast.makeText(this, "登录成功"+it.data.token, Toast.LENGTH_SHORT).show()
//            },{
//                Log.i("====", "error: ")
//            })


    }

}