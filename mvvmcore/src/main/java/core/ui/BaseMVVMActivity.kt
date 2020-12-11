package core.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import core.BaseViewModel
import core.api.IActivity

abstract class BaseMVVMActivity<VM : BaseViewModel<*>,V : ViewDataBinding> :AppCompatActivity(), IActivity {
    protected lateinit var viewModel:VM
    protected lateinit var binding:V
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layoutID())
        viewModel = createViewModel()
        binding.setVariable(getVariable(),viewModel)
        initData()
        initView()
    }

    abstract fun getVariable(): Int
    abstract fun createViewModel(): VM
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