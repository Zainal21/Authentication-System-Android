package com.zain.social_authenticated.ui.injector

import com.zain.social_authenticated.ui.base.BaseInterface


interface Presenter<V : BaseInterface> {
    fun attachView(baseInterface: V)
    fun detachView()
}