package com.example.usercenter.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.baweigame.xmpplibrary.XmppManager
import com.example.net.BaseEntity
import com.example.observ.customObserver
import com.example.observ.customXMppObserver
import com.example.usercenter.model.UserModel
import com.example.usercenter.model.api.bean.LoginBean
import com.example.usercenter.model.api.bean.UserBody
import core.BaseViewModel

class LoginViewModel : BaseViewModel<BaseEntity<LoginBean>,String,UserModel>() {
    override fun createModel():UserModel {
        return UserModel()
    }
    fun login(username:String,pwd:String){
        mModel.login(UserBody(username,username,pwd))
            .customXMppObserver({
                XmppManager.getInstance().xmppUserManager.login(username,pwd)
            },{
                _netSuccess.apply { value=it }
            },{
                _netFailure.apply { value=it.message }
            })
    }
}