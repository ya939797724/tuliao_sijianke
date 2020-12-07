package core

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import java.lang.NullPointerException

abstract class BaseViewModel<M : IModel> : LifecycleObserver{
    protected var mModel:M? = null
    protected var mOwner:LifecycleOwner? = null

    abstract fun createModel()

    protected fun BaseViewModel(owner: LifecycleOwner){
        if (owner == null){
            throw NullPointerException("owner is not null·····")
        }
        mOwner = owner
        owner.lifecycle.addObserver(this)
        createModel()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectionView(){
        BindView()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun disconnectionView(){
        UnBindView()
    }

    abstract fun BindView()

    abstract fun UnBindView()
}