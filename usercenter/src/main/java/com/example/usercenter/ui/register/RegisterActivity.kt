package com.example.usercenter.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.usercenter.BR
import com.example.usercenter.R
import com.example.usercenter.databinding.ActivityRegisterBinding
import core.ui.BaseMVVMActivity
@Route(path = ActivitySwitch.UserCenter.REGISTER_ACT)
class RegisterActivity : BaseMVVMActivity<RegisterViewModel,ActivityRegisterBinding>() {
    override fun layoutID(): Int {
       return R.layout.activity_register
    }

    override fun initData() {
        ARouter.getInstance().inject(this)
    }

    override fun initView() {
        //点击注册按钮，获取用户输入账号
        binding.ucBtRegister.setOnClickListener {
            val username = binding.ucEtRUsername.text.toString()
            val pwd = binding.ucEtRPwd01.text.toString()
            viewModel.register(username, pwd)
        }
        //注册成功回调
        viewModel.netSuccess.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            finish()
        })
        viewModel.netFailure.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun getVariable(): Int {
       return BR.viewModel
    }

    override fun createViewModel(): RegisterViewModel {
       return ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(RegisterViewModel::class.java)
    }

}