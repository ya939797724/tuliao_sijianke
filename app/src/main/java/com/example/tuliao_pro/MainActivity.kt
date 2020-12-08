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
<<<<<<< HEAD
<<<<<<< HEAD
=======



>>>>>>> dev1
=======

<<<<<<< HEAD
=======
        var log = MLogFile(File("/storage/emulated/0","log.txt"))
        val logUtil = MLogUtil.Builder()
            .addLog(log)
            .addLog(MLogcat())
            .isDebug(true)
            .build()

        logUtil.print("杨明乙")

>>>>>>> 8a0a215e5c35591f4a4e651e2b8e442cf13725d6
>>>>>>> d50ca092374246fede2de57d7f7885968aebd765
    }
}
