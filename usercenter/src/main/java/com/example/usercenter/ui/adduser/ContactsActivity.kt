package com.example.usercenter.ui.adduser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.usercenter.R
import com.example.usercenter.ui.adduser.entity.CusTabEntity
import com.example.usercenter.ui.adduser.fragments.Contocts_Flock_Fragment
import com.example.usercenter.ui.adduser.fragments.Contocts_Fridends_Fragment
import com.example.usercenter.ui.adduser.fragments.Contocts_Group_Fragment
import com.flyco.tablayout.listener.CustomTabEntity
import kotlinx.android.synthetic.main.activity_contacts.*

/**
 * 联系人
 */
@Route(path = ActivitySwitch.UserCenter.CONTACTS_ACT)
class ContactsActivity : AppCompatActivity() {
    var contactscustabs= arrayListOf<CustomTabEntity>()
    var contactsfragments = arrayListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        ARouter.getInstance().inject(this)
        contactsfragments.add(Contocts_Fridends_Fragment())
        contactsfragments.add(Contocts_Group_Fragment())
        contactsfragments.add(Contocts_Flock_Fragment())
        contactscustabs.add(CusTabEntity("好友",0,0))
        contactscustabs.add(CusTabEntity("分组",0,0))
        contactscustabs.add(CusTabEntity("群聊",0,0))
        contacts_comm.setTabData(contactscustabs,this,R.id.contacts_fm,contactsfragments)


        iv_add_user.setOnClickListener {
            ARouter.getInstance().build(ActivitySwitch.UserCenter.ADD_USER_ACT).navigation()
        }
    }
}