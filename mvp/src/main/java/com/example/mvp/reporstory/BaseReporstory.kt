package com.example.mvp.reporstory

import com.example.mvp.model.IModel

abstract class BaseReporstory<M : IModel> {

    protected lateinit var mModel:M
    abstract fun setModel()

    init {
        setModel()
    }


}