package com.example.zxcode

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.usercenter.R

import com.uuzuche.lib_zxing.activity.CaptureActivity
import com.uuzuche.lib_zxing.activity.CodeUtils
import kotlinx.android.synthetic.main.activity_zx.*

class ZxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zx)

        val mBitmap = CodeUtils.createImage("我是啊哈哈", 400, 400, BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
        zx_img.setImageBitmap(mBitmap)
        Toast.makeText(this,"打开了扫描二维码",Toast.LENGTH_SHORT).show()
        zx_img.setOnClickListener {
            startActivityForResult(Intent(this, CaptureActivity::class.java),100)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}