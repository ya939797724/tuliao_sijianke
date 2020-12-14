package com.example.tuliao_pro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.common.log.MLogUtil
import com.example.common.log.impl.MLogFile
import com.example.common.log.impl.MLogcat
import com.example.common.sp.SPUtil
import java.io.File

class MainActivity : AppCompatActivity() {
    var username by SPUtil<MutableSet<String>>(this,"username", mutableSetOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
