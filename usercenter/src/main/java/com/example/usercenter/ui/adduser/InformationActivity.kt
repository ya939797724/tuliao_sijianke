package com.example.usercenter.ui.adduser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.usercenter.R

/**
 * 消息页面
 */
@Route(path = ActivitySwitch.UserCenter.INFORMATION_ACT)
class InformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        ARouter.getInstance().inject(this)
    }
}