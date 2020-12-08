package core.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import core.BaseViewModel

abstract class BaseMVVMFragment<VM : BaseViewModel<*>,V : ViewDataBinding> : BaseFragment() {
    protected var viewModel:VM? = null
    protected var binding:V? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        initDataBinding()
        initObservable()
        super.onCreate(savedInstanceState)
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this!!.activity!!,bandLayout())
        viewModel = createViewModel()
        binding!!.setVariable(getVariable(),viewModel)
    }

    abstract fun getVariable(): Int

    abstract fun createViewModel(): VM?

    abstract fun initObservable()

}