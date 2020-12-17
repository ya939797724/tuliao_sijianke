package com.example.usercenter.ui.login

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.baweigame.xmpplibrary.XmppManager
import com.example.common.arouter.ActivitySwitch
import com.example.common.sp.SPUtil
import com.example.net.RetrofitFactory
import com.example.usercenter.BR
import com.example.usercenter.R
import com.example.usercenter.databinding.ActivityLoginBinding
import com.example.usercenter.ui.register.RegisterActivity
import core.ui.BaseMVVMActivity

@Route(path = ActivitySwitch.UserCenter.LOGIN_ACT)
class LoginActivity : BaseMVVMActivity<LoginViewModel,ActivityLoginBinding>() {
    //sp存储
    private var userToken by SPUtil<String>(this,"userToken","")
    private var usernameSp by SPUtil<String>(this,"username","")
    private var pwdSp by SPUtil<String>(this,"pwd","")
    //判断是否需要存储密码
    private var isSavePwd:Boolean = false
    //成员变量用户名密码
    private var username = ""
    private var pwd = ""
    override fun layoutID(): Int {
        return R.layout.activity_login
    }

    override fun initData() {
        ARouter.getInstance().inject(this)
        //预加载上次输入的用户名密码
        binding.ucEtUsername.setText(usernameSp)
        binding.ucEtPwd.setText(pwdSp)
        if(usernameSp.isNotEmpty()&&pwdSp.isNotEmpty()){
            binding.ucIsSavePwd.isChecked = true
        }
    }

    override fun initView() {
        //跳转注册页面
        binding.ucBtToRegister.setOnClickListener {
            startActivity(RegisterActivity::class.java)
        }
        //登录
        binding.ucBtLogin.setOnClickListener {
            //获取用户输入
             username = binding.ucEtUsername.text.toString()
             pwd = binding.ucEtPwd.text.toString()

            usernameSp = username//将username存入sp
            viewModel.login(username,pwd)//调用方法网络请求
        }
        //判断是否需要保存密码
        binding.ucIsSavePwd.setOnCheckedChangeListener { buttonView, isChecked ->
            isSavePwd = isChecked
        }
        //登录成功回调
        viewModel.netSuccess.observe(this, Observer {
            userToken = it.data.token//sp添加token
            RetrofitFactory.setToken(userToken)//网络请求添加token
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
            if(isSavePwd){//sp保存密码
                pwdSp = pwd
            }else{
                pwdSp = ""
            }
            ARouter.getInstance().build(ActivitySwitch.Home.HOME_ACT).navigation()
        })
        viewModel.netFailure.observe(this, Observer {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show()
        })
    }
    //布局初始化viewModel
    override fun getVariable(): Int {
        return BR.viewModel
    }
    //代码初始化viewModel
    override fun createViewModel(): LoginViewModel {
        var model = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(LoginViewModel::class.java)
      return model
    }


}
