package com.example.usercenter.ui.adduser

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.usercenter.R
import com.uuzuche.lib_zxing.activity.CaptureFragment
import com.uuzuche.lib_zxing.activity.CodeUtils
import com.uuzuche.lib_zxing.activity.CodeUtils.AnalyzeCallback


class SaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sao)
        /**
         * 执行扫面Fragment的初始化操作
         */
        /**
         * 执行扫面Fragment的初始化操作
         */
        val captureFragment = CaptureFragment()
        // 为二维码扫描界面设置定制化界面
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.saomiao)

        captureFragment.analyzeCallback = analyzeCallback
        /**
         * 替换我们的扫描控件
         */
        /**
         * 替换我们的扫描控件
         */
        supportFragmentManager.beginTransaction().replace(R.id.viewfinder_view, captureFragment)
            .commit()

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
                    Toast.makeText(this@SaoActivity, "解析二维码失败", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    /**
     * 二维码解析回调函数
     */
    var analyzeCallback: AnalyzeCallback? = object : AnalyzeCallback {
        override fun onAnalyzeSuccess(mBitmap: Bitmap, result: String) {
            val resultIntent = Intent()
            val bundle = Bundle()
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS)
            bundle.putString(CodeUtils.RESULT_STRING, result)
            resultIntent.putExtras(bundle)
            this@SaoActivity.setResult(RESULT_OK, resultIntent)
            this@SaoActivity.finish()
        }

        override fun onAnalyzeFailed() {
            val resultIntent = Intent()
            val bundle = Bundle()
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED)
            bundle.putString(CodeUtils.RESULT_STRING, "")
            resultIntent.putExtras(bundle)
            this@SaoActivity.setResult(RESULT_OK, resultIntent)
            this@SaoActivity.finish()
        }
    }

}