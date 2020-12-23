package com.example.zxcode.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.baweigame.xmpplibrary.XmppManager
import com.example.usercenter.R
import com.example.zxcode.ZxActivity
import kotlinx.android.synthetic.main.layout_search_people.*

class Search_People_Fragment :Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_search_people, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchpeople_ed.setOnClickListener {
            val searchFriends = XmppManager.getInstance().xmppFriendManager.searchFriends("123321")
            Log.i("====", "onActivityCreated: $searchFriends")
        }
    }
}