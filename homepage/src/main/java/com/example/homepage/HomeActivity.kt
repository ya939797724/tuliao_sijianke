package com.example.homepage

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.widget.GridView
import android.widget.PopupWindow
import basemap.BaseMapActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.bottom_navigation.*
import kotlin.String.Companion as String1
@Route(path = ActivitySwitch.Home.HOME_ACT)
class HomeActivity : BaseMapActivity() {
    lateinit var popupWindow:PopupWindow
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)

        addMap(homemap,savedInstanceState)

        iv_activity.setOnClickListener {

        }
        iv_camera.setOnClickListener {

        }
        iv_msg.setOnClickListener {
            ARouter.getInstance().build(ActivitySwitch.UserCenter.INFORMATION_ACT).navigation()
        }
        iv_space.setOnClickListener {

        }
        iv_contacts.setOnClickListener {
            ARouter.getInstance().build(ActivitySwitch.UserCenter.CONTACTS_ACT).navigation()
        }
    }

    override fun bandLayout(): Int {
        return R.layout.activity_home
    }


}
