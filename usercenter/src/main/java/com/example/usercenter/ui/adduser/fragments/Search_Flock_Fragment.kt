package com.example.zxcode.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.usercenter.R
import com.example.usercenter.ui.adduser.CreateFlockActivity
import com.example.usercenter.ui.adduser.InformationActivity
import com.example.usercenter.ui.adduser.fragments.Flock_Fans_Fragment
import com.example.usercenter.ui.adduser.fragments.Flock_Fridends_Fragment
import com.example.usercenter.ui.adduser.fragments.Flock_Game_Fragment
import kotlinx.android.synthetic.main.layout_search_flock.*


class Search_Flock_Fragment :Fragment(){
    var arrayFlock = arrayOf<String>("游戏","粉丝","交友")
    var flockFragments= arrayListOf<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_search_flock, null)
        flockFragments.add(Flock_Game_Fragment())
        flockFragments.add(Flock_Fans_Fragment())
        flockFragments.add(Flock_Fridends_Fragment())
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        searchflock_tv_addflock.setOnClickListener {
            startActivity(Intent(context,CreateFlockActivity::class.java))
        }
        //TODO 这个地方的上下文可能有问题
        searchflock_tab.setViewPager(searchflock_vp,arrayFlock,
            context as FragmentActivity?,flockFragments)
        super.onActivityCreated(savedInstanceState)

    }
}