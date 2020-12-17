package com.example.tuliao_pro

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD

=======
//        ARouter.getInstance().build(ActivitySwitch.UserCenter.TEST_ACT).navigation()
>>>>>>> 1a5fa715d6c16be138b5ff937f06c847f48641e3
    }
}
