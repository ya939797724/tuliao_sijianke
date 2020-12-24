package com.example.usercenter.ui.adduser.fragments

import android.app.AlertDialog
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.sp.SPUtil
import com.example.usercenter.BR
import com.example.usercenter.R
import com.example.usercenter.adapter.SearchUserRecyclerViewAdapter
import com.example.usercenter.databinding.SearchUserDataBinding
import com.example.usercenter.model.api.bean.AddFriendBean
import com.example.usercenter.model.api.bean.UserInfoBean
import com.example.usercenter.ui.adduser.AddUserViewModel
import core.ui.BaseMVVMFragment

class SearchPeopleFragment : BaseMVVMFragment<AddUserViewModel, SearchUserDataBinding>() {
    override fun layoutID(): Int {
        return R.layout.layout_search_people
    }
    private var userIdSp:Int = 0
    lateinit var mAdapter: SearchUserRecyclerViewAdapter
    var userDatas = mutableListOf<UserInfoBean>()
    lateinit var headerView: View
    lateinit var btSearchUser: ImageButton
    lateinit var tvAddUser: EditText
    lateinit var tvAddPhoneContacts: TextView
    lateinit var tvFace2Face: TextView
    var friendId = 0
    var alias = ""
    override fun initData() {
        binding.bind = this
        userIdSp = SPUtil<Int>(context!!,"userId",0).findPreference("userId",0)
        mAdapter = SearchUserRecyclerViewAdapter(R.layout.recycler_search_user, userDatas)
        headerView = layoutInflater.inflate(R.layout.search_people_header, null);
        btSearchUser = headerView.findViewById<ImageButton>(R.id.bt_search_user)
        tvAddUser = headerView.findViewById<EditText>(R.id.search_add_user)
        tvAddPhoneContacts = headerView.findViewById<TextView>(R.id.add_phone_contacts)
        tvFace2Face = headerView.findViewById<TextView>(R.id.face_to_face_add_user)
        viewModelCallback()
    }

    override fun initView() {
        btSearchUser.setOnClickListener {
            val username = tvAddUser.text.toString()
            if (username.isNotEmpty()) {
                viewModel.searchUser(username)
            } else {
                toast("输入为空无法搜索", it)
            }
        }
        mAdapter.addHeaderView(headerView)

        val dialog = AlertDialog.Builder(context).create()
        dialog.setTitle("是否要发送好友申请？")
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"取消") { dialog, which ->
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定") { dialog, which ->
            viewModel.addUser(AddFriendBean(0,alias,friendId,0,userIdSp))
            toast("请求已发送",view)
            dialog.dismiss()
        }
        mAdapter.setOnItemChildClickListener { adapter, view, position ->
            val user = userDatas.get(position)
            friendId = user.id
            alias = user.phonenumber
            dialog.show()
        }
    }
    fun viewModelCallback(){
        viewModel.netSuccess.observe(this, Observer {
            userDatas.clear()
            userDatas.addAll(it)
            mAdapter.notifyDataSetChanged()
        })

        viewModel.netFailure.observe(this, Observer {
            toast(it)
        })
        viewModel.addUserSuccess.observe(this, Observer {
            if(it){
                toast("发送成功")
            }else{
                toast("发送失败")
            }
        })
    }
    override fun getVariable(): Int {
        return BR.viewModel
    }

    override fun createViewModel(): AddUserViewModel {
        return ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(AddUserViewModel::class.java)
    }

    fun getRecyclerLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(context)
    }

}