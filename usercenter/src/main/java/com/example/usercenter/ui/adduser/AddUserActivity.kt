package com.example.zxcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.usercenter.R

import com.example.zxcode.fragments.Search_Flock_Fragment
import com.example.zxcode.fragments.Search_People_Fragment
import kotlinx.android.synthetic.main.activity_add_user.*


class AddUserActivity : AppCompatActivity() {
    var arrayAddUser = arrayOf<String>("找人","找群")
    var addUserFragments= arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        /**
         * 添加群或者联系人的总viewpager
         */

        addUserFragments.add(Search_People_Fragment())
        addUserFragments.add(Search_Flock_Fragment())
        adduser_tv_slid.setViewPager(useradd_vp,arrayAddUser,this,addUserFragments)
        /**
         * 点击返回直接finish
         */
        adduser_return.setOnClickListener {
            finish()
        }
    }
}