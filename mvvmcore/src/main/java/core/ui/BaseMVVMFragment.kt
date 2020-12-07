package core.ui

import android.database.DatabaseUtils
import android.os.Bundle
import core.BaseViewModel

abstract class BaseMVVMFragment<VM : BaseViewModel<*>> : BaseFragment() {
    protected var viewModel:VM? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        createViewModel()
        super.onCreate(savedInstanceState)
    }
    abstract fun createViewModel()
}