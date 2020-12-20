package com.example.zxcode.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.usercenter.R
import com.example.usercenter.ui.adduser.CreateFlockActivity
import com.example.usercenter.ui.adduser.InformationActivity
import kotlinx.android.synthetic.main.layout_search_flock.*


class Search_Flock_Fragment :Fragment(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_search_flock, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        searchflock_tv_addflock.setOnClickListener {
            startActivity(Intent(context,CreateFlockActivity::class.java))
        }

        super.onActivityCreated(savedInstanceState)

    }
}