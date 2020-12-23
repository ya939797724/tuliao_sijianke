package com.example.usercenter.ui.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.usercenter.R

/**
 * 手机联系人
 */
@Route(path = ActivitySwitch.UserCenter.PHONE_CONTACTS_ACT)
class PhoneContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_contacts)
        ARouter.getInstance().inject(this)

    }
}