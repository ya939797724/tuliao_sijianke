package com.example.tuliao_pro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.common.sp.SPUtil

class MainActivity : AppCompatActivity() {
    var username by SPUtil<MutableSet<String>>(this,"username", mutableSetOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
