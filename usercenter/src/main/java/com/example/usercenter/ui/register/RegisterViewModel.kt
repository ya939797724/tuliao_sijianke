package com.example.usercenter.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.baweigame.xmpplibrary.XmppManager
import com.example.observ.customObserver
import com.example.observ.customXMppObserver
import com.example.usercenter.model.UserModel
import com.example.usercenter.model.api.bean.UserBody
import core.BaseViewModel

class RegisterViewModel : BaseViewModel<String,String,UserModel>(){

    override fun createModel(): UserModel {
       return UserModel()
    }

    fun register(username:String,pwd:String){
        mModel.register(UserBody(username,username,pwd))
            .customXMppObserver({
                XmppManager.getInstance().xmppUserManager.createAccount(username,pwd)
                true
            },{
                if(it.data){
                    _netSuccess.apply { value="注册成功" }
                }else{
                    _netFailure.apply { value="注册失败" }
                }
            },{
                _netFailure.apply { value="注册失败" }
            })


    }
}