package com.example.usercenter.ui

import androidx.lifecycle.LifecycleOwner
import com.example.usercenter.model.UserModel
import core.BaseViewModel

class LoginActivityViewModel : BaseViewModel<UserModel>() {

    override fun createModel():UserModel {
        return UserModel()
    }


}