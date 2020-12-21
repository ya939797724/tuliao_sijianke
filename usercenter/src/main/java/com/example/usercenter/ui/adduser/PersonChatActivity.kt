package com.example.usercenter.ui.adduser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.usercenter.R
import com.example.usercenter.ui.adduser.entity.CusTabEntity
import com.example.usercenter.ui.adduser.fragments.*
import com.flyco.tablayout.listener.CustomTabEntity
import kotlinx.android.synthetic.main.activity_person_chat.*

/**
 * 单人聊天
 */
@Route(path = ActivitySwitch.UserCenter.PERSON_ACT)
class PersonChatActivity : AppCompatActivity() {
    var personchatcus= arrayListOf<CustomTabEntity>()
    var personchatfragments= arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_chat)
        ARouter.getInstance().inject(this)
        commtabInit()



    }

    private fun commtabInit() {
        personchatcus.add(CusTabEntity("",R.drawable.ic_record,R.drawable.ic_record))
        personchatcus.add(CusTabEntity("",R.drawable.ic_image,R.drawable.ic_image))
        personchatcus.add(CusTabEntity("",R.drawable.ic_camera,R.drawable.ic_camera))
        personchatcus.add(CusTabEntity("",R.drawable.ic_location,R.drawable.ic_location))
        personchatcus.add(CusTabEntity("",R.drawable.ic_smeil,R.drawable.ic_smeil))
        personchatcus.add(CusTabEntity("",R.drawable.ic_type,R.drawable.ic_type))
        personchatfragments.add(Chat_Voice_Fragment())
        personchatfragments.add(Chat_Picture_Fragment())
        personchatfragments.add(Chat_Camera_Fragment())
        personchatfragments.add(Chat_Loc_Fragment())
        personchatfragments.add(Chat_Face_Fragment())
        personchatfragments.add(Chat_Setting_Fragment())

        personchat_comm.setTabData(personchatcus,this,R.id.personchat_fl,personchatfragments)
    }
}