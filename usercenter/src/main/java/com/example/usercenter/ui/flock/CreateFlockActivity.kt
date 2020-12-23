package com.example.usercenter.ui.flock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.usercenter.R
@Route(path = ActivitySwitch.UserCenter.CREATE_FLOCK_ACT)
class CreateFlockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_flock)
        ARouter.getInstance().inject(this)
    }
}