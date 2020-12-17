package com.example.homepage

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import basemap.BaseMapActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.String.Companion as String1

class HomeActivity : BaseMapActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        addMap(homemap,savedInstanceState)

    }

    override fun bandLayout(): Int {
        return R.layout.activity_home
    }
}
