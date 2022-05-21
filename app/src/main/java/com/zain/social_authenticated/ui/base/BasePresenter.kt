package com.zain.social_authenticated.ui.base

import com.zain.social_authenticated.ui.injector.Presenter
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : BaseInterface> : Presenter<T> {

    private val isViewAttached: Boolean get() = View != null
    var View: T? = null
    var disposables: CompositeDisposable? = null

    override fun attachView(baseInterface: T) {
        this.View = baseInterface
        disposables = CompositeDisposable()
    }

    override fun detachView() {
        View = null
        disposables?.dispose()
        disposables?.clear()
    }

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }


    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter")
}