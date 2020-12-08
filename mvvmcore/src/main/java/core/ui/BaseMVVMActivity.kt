package core.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import core.BaseViewModel

abstract class BaseMVVMActivity<VM : BaseViewModel<*>,V : ViewDataBinding> : BaseActivity() {
    protected var viewModel:VM? = null
    protected var binding:V? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        initObservable()
    }

    fun initDataBinding(){
        binding = DataBindingUtil.setContentView(this,bandLayout())
        viewModel = createViewModel()
        binding!!.setVariable(getVariable(),viewModel)
    }

    abstract fun getVariable(): Int

    abstract fun createViewModel(): VM

    abstract fun initObservable()

}