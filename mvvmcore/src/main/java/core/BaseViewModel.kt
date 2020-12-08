package core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import core.api.IViewModel
import java.lang.NullPointerException

abstract class BaseViewModel<M : IModel> : IViewModel{
    protected lateinit var mModel:M
    protected lateinit var mOwner:LifecycleOwner

    abstract fun createModel()

    protected fun BaseViewModel(owner: LifecycleOwner){
        if (owner == null){
            throw NullPointerException("owner is not null·····")
        }
        mOwner = owner
        mOwner.lifecycle.addObserver(this)
        createModel()
    }

}