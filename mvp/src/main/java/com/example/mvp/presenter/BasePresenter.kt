package com.example.mvp.presenter

import com.example.mvp.reporstory.BaseReporstory
import com.example.mvp.view.IView

abstract class BasePresenter<R:BaseReporstory<*>,V:IView> {
    protected lateinit var mReporstory:R
    abstract fun setReporstory()

    init {
        setReporstory()
    }


}