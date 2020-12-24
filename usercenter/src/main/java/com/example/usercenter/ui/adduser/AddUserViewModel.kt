package com.example.usercenter.ui.adduser

import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.attribute.recyclerview.RecyclerAdapter
import com.example.net.BaseEntity
import com.example.observ.customObserver
import com.example.usercenter.R
import com.example.usercenter.adapter.SearchUserRecyclerViewAdapter
import com.example.usercenter.model.UserModel
import com.example.usercenter.model.api.bean.AddFriendBean
import com.example.usercenter.model.api.bean.UserInfoBean
import core.BaseViewModel

class AddUserViewModel : BaseViewModel<MutableList<UserInfoBean>,String,UserModel>() {

   private var _addUserSuccess = MutableLiveData<Boolean>()
   var addUserSuccess = _addUserSuccess

    override fun createModel(): UserModel {
        return UserModel();
    }
    fun searchUser(userName:String){
        mModel.searchUser(userName).customObserver({
            _netSuccess.apply {
                value = it.data
            }
        },{
            _netFailure.apply {
                value = "获取失败，请检查网络"
            }
        })
    }

    fun addUser(friendBean: AddFriendBean){
        mModel.addUser(friendBean)
            .customObserver({
                _addUserSuccess.apply { value = it.data }
            },{
                _netFailure.apply { value = "添加失败" }
            })
    }


}