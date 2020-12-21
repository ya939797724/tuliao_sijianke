package com.example.usercenter.ui.adduser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.usercenter.R

/**
 * 聊天设置
 */
@Route(path = ActivitySwitch.UserCenter.SETTING_ACT)
class ChatSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_setting)
        ARouter.getInstance().inject(this)
    }
}