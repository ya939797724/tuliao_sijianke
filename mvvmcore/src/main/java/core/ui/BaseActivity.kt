package core.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import core.api.IActivity
import core.api.IView

abstract class BaseActivity : AppCompatActivity(),IActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID())
        initData()
        initView()
    }

    override fun startActivity(activity: Class<*>?) {
        val intent = Intent(this,activity)
        startActivity(intent)
    }

    override fun startActivity(activity: Class<*>?, data: Bundle?, paramName: String?) {
        val intent = Intent(this,activity)
        intent.putExtra(paramName,data)
        startActivity(intent)
    }
}