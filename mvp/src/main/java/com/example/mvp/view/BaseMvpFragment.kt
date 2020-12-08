package com.example.mvp.view

import com.example.mvp.presenter.BasePresenter

abstract class BaseMvpFragment<P:BasePresenter<*,*>>: BaseFragment() {
    protected lateinit var BasePresenter:P

    abstract fun setPresenter()

    init {
        setPresenter()
    }


}