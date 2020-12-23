package com.example.tuliao_pro

import android.os.Build
import android.os.Bundle
import android.widget.Switch
//import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(  "android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.ACCESS_NETWORK_STATE",
                "android.permission.ACCESS_WIFI_STATE",
                "android.permission.READ_PHONE_STATE",
                "android.permission.ACCESS_COARSE_LOCATION",
                "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS",
                "android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.CHANGE_WIFI_STATE",
                "android.permission.ACCESS_FINE_LOCATION"),100)
        }
    }
}
