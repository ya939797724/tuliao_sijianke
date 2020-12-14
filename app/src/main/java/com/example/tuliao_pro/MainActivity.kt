package com.example.tuliao_pro

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.common.log.MLogUtil
import com.example.common.log.impl.MLogFile
import com.example.common.log.impl.MLogcat
import com.example.common.sp.SPUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    var username by SPUtil<MutableSet<String>>(this,"username", mutableSetOf())
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< HEAD
=======
        baselinear.addItem(getDrawable(R.mipmap.ic_launcher_round))
        baselinear.addItem(getDrawable(R.mipmap.ic_launcher_round))
        baselinear.addItem(getDrawable(R.mipmap.ic_launcher_round))
        baselinear.addItem(getDrawable(R.mipmap.ic_launcher_round))
        baselinear.addItem(getDrawable(R.mipmap.ic_launcher_round))
>>>>>>> dev
    }
}
