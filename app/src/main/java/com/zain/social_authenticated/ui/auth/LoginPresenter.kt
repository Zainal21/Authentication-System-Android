package com.zain.social_authenticated.ui.auth

import com.zain.social_authenticated.model.request.LoginRequest
import com.zain.social_authenticated.network.APIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginPresenter(
 private val view: LoginView.View
) : LoginView.Presenter{
    private val mCompositeDisposable: CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun sendAuthentication(username : String, password : String) {
        view.showLoading()
        val disposable = APIService.endpoint.authenticated(username, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.HideLoading()
                if(it.status == true){
                    view.onSuccessLogin(it)
                }
            },{
                view.HideLoading()
                view.onRejectLogin(it.message.toString())
            })

        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        mCompositeDisposable!!.clear()
    }


}