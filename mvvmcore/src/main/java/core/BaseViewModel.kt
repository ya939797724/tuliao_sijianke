package core

import androidx.lifecycle.*
import core.api.IViewModel
import java.lang.NullPointerException

abstract class BaseViewModel<S,E,M : IModel>:ViewModel() {
    protected val _netSuccess = MutableLiveData<S>()
    var netSuccess: LiveData<S> = _netSuccess

    protected val _netFailure = MutableLiveData<E>()
    var netFailure: LiveData<E> = _netFailure
    protected lateinit var mModel: M
    init {
        mModel =createModel()
    }
    abstract fun createModel():M


}