package core.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bandLayout())

        initView()

        initData()

        initEvent()
    }

    abstract fun initEvent()

    abstract fun initData()

    abstract fun initView()

    abstract fun bandLayout(): Int

    fun showShortToast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }


}