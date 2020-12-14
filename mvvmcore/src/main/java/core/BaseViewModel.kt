package core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import core.api.IViewModel
import java.lang.NullPointerException

abstract class BaseViewModel<M : IModel> {
    protected lateinit var mModel: M
    init {
        mModel = mModel
    }
    abstract fun createModel():M


}