package com.example.zxcode

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.arouter.ActivitySwitch
import com.example.usercenter.R
import com.example.usercenter.ui.adduser.SaoActivity

import com.uuzuche.lib_zxing.activity.CaptureActivity
import com.uuzuche.lib_zxing.activity.CodeUtils
import kotlinx.android.synthetic.main.activity_zx.*
@Route(path = ActivitySwitch.UserCenter.ZX_ACT)
class ZxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zx)
        ARouter.getInstance().inject(this)
        val mBitmap = CodeUtils.createImage("我是啊哈哈", 400, 400, BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
        zx_img.setImageBitmap(mBitmap)
        Toast.makeText(this,"打开了扫描二维码",Toast.LENGTH_SHORT).show()
        zx_img.setOnClickListener {
            startActivityForResult(Intent(this, CaptureActivity::class.java),100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === 100) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                var bundle: Bundle
                bundle = data.extras!!
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    val result = bundle.getString(CodeUtils.RESULT_STRING)
                    Toast.makeText(this, "解析结果:$result", Toast.LENGTH_LONG).show()
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}