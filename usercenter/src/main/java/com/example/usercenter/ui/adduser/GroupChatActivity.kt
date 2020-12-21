package com.example.usercenter.ui.adduser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.usercenter.R
import com.example.usercenter.ui.adduser.entity.CusTabEntity
import com.example.usercenter.ui.adduser.fragments.*
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_group_chat.*
import kotlinx.android.synthetic.main.activity_person_chat.*
import kotlinx.android.synthetic.main.activity_person_chat.personchat_comm

class GroupChatActivity : AppCompatActivity() {
    var personchatcus= arrayListOf<CustomTabEntity>()
    var personchatfragments= arrayListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_chat)
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

        group_comm.setTabData(personchatcus,this,R.id.group_fl,personchatfragments)
    }

}