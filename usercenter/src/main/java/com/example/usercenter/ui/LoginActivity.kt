package com.example.usercenter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.net.RetrofitFactory
import com.example.usercenter.R

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        logintoRig.setOnClickListener {

            startActivity(Intent(LoginActivity@this,RegisterActivity::class.java))
        }


    }
}
