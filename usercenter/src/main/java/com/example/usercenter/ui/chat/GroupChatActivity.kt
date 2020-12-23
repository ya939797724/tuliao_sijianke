package com.example.usercenter.ui.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.usercenter.R
import com.example.usercenter.model.api.bean.CusTabEntity
import com.example.usercenter.ui.chat.fragment.*
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_group_chat.*

/**
 * 群组聊天
 */
@Route(path = ActivitySwitch.UserCenter.GROUP_CHAT_ACT)
class GroupChatActivity : AppCompatActivity() {
    var personchatcus= arrayListOf<CustomTabEntity>()
    var personchatfragments= arrayListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_chat)
        ARouter.getInstance().inject(this)
        commtabInit()

        et_send_msg.setOnClickListener {
            group_fl.visibility = View.GONE
        }

        group_comm.setOnTabSelectListener(object : OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                group_fl.visibility = View.VISIBLE
            }

            override fun onTabReselect(position: Int) {
                group_fl.visibility = View.VISIBLE
            }

        })
    }

    private fun commtabInit() {
        personchatcus.add(
            CusTabEntity(
                "",
                R.drawable.ic_record,
                R.drawable.ic_record
            )
        )
        personchatcus.add(
            CusTabEntity(
                "",
                R.drawable.ic_image,
                R.drawable.ic_image
            )
        )
        personchatcus.add(
            CusTabEntity(
                "",
                R.drawable.ic_camera,
                R.drawable.ic_camera
            )
        )
        personchatcus.add(
            CusTabEntity(
                "",
                R.drawable.ic_location,
                R.drawable.ic_location
            )
        )
        personchatcus.add(
            CusTabEntity(
                "",
                R.drawable.ic_smeil,
                R.drawable.ic_smeil
            )
        )
        personchatcus.add(
            CusTabEntity(
                "",
                R.drawable.ic_type,
                R.drawable.ic_type
            )
        )
        personchatfragments.add(Chat_Voice_Fragment())
        personchatfragments.add(Chat_Picture_Fragment())
        personchatfragments.add(Chat_Camera_Fragment())
        personchatfragments.add(Chat_Loc_Fragment())
        personchatfragments.add(Chat_Face_Fragment())
        personchatfragments.add(Chat_Setting_Fragment())

        group_comm.setTabData(personchatcus,this,R.id.group_fl,personchatfragments)
    }

}