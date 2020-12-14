package com.example.usercenter.ui

import androidx.lifecycle.LifecycleOwner
import com.example.usercenter.model.UserModel
import core.BaseViewModel

class LoginActivityViewModel : BaseViewModel<UserModel> {
    constructor(mOwner: LifecycleOwner) : super(mOwner)


    override fun createModel() {
        mModel = UserModel()
    }

    override fun bindView() {

    }

    override fun unBindView() {

    }
}