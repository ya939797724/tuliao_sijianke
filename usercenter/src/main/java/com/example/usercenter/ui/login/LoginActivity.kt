package com.example.usercenter.ui.login

import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.baweigame.xmpplibrary.XmppManager
import com.example.usercenter.BR
import com.example.usercenter.R
import com.example.usercenter.databinding.ActivityLoginBinding
import com.example.usercenter.ui.register.RegisterActivity
import com.example.zxcode.AddUserActivity
import core.ui.BaseMVVMActivity


class LoginActivity : BaseMVVMActivity<LoginViewModel,ActivityLoginBinding>() {
    override fun layoutID(): Int {
        return R.layout.activity_login
    }

    override fun initData() {

    }

    override fun initView() {
        binding.ucBtToRegister.setOnClickListener {
            startActivity(RegisterActivity::class.java)
        }
        binding.ucBtLogin.setOnClickListener {
            val username = binding.ucEtUsername.text.toString()
            val pwd = binding.ucEtPwd.text.toString()
            viewModel.login(username,pwd)
        }

        viewModel.netSuccess.observe(this, Observer {
            val isUserOnLine = XmppManager.getInstance().xmppUserManager.IsUserOnLine("12345678911")
            Toast.makeText(this, "登录成功"+isUserOnLine, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,AddUserActivity::class.java))
        })
        viewModel.netFailure.observe(this, Observer {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show()
        })
    }

    override fun getVariable(): Int {
        return BR.viewModel
    }

    override fun createViewModel(): LoginViewModel {
        var model = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(LoginViewModel::class.java)
      return model
    }


}
