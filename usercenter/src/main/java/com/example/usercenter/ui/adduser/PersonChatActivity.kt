package com.example.usercenter.ui.adduser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.usercenter.R
import com.example.usercenter.ui.adduser.entity.CusTabEntity
import com.example.usercenter.ui.adduser.fragments.*
import com.flyco.tablayout.listener.CustomTabEntity
import kotlinx.android.synthetic.main.activity_person_chat.*

class PersonChatActivity : AppCompatActivity() {
    var personchatcus= arrayListOf<CustomTabEntity>()
    var personchatfragments= arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_chat)
        commtabInit()



    }

    private fun commtabInit() {
        personchatcus.add(CusTabEntity("",R.mipmap.yuyin,R.mipmap.yuyin))
        personchatcus.add(CusTabEntity("",R.mipmap.picture,R.mipmap.picture))
        personchatcus.add(CusTabEntity("",R.mipmap.camera,R.mipmap.camera))
        personchatcus.add(CusTabEntity("",R.mipmap.myloc,R.mipmap.myloc))
        personchatcus.add(CusTabEntity("",R.mipmap.biaoqing,R.mipmap.biaoqing))
        personchatcus.add(CusTabEntity("",R.mipmap.kuai,R.mipmap.kuai))
        personchatfragments.add(Chat_Voice_Fragment())
        personchatfragments.add(Chat_Picture_Fragment())
        personchatfragments.add(Chat_Camera_Fragment())
        personchatfragments.add(Chat_Loc_Fragment())
        personchatfragments.add(Chat_Face_Fragment())
        personchatfragments.add(Chat_Setting_Fragment())

        personchat_comm.setTabData(personchatcus,this,R.id.personchat_fl,personchatfragments)
    }
}