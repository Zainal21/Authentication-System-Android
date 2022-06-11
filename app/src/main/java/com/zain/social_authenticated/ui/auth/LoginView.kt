package com.zain.social_authenticated.ui.auth

import com.zain.social_authenticated.base.BasePresenter
import com.zain.social_authenticated.base.BaseView
import com.zain.social_authenticated.model.request.LoginRequest
import com.zain.social_authenticated.model.response.LoginResponse

interface LoginView {
    interface View : BaseView{
        fun onSuccessLogin(response : LoginResponse)
        fun onRejectLogin(message : String)
    }

    interface Presenter : LoginView, BasePresenter{
        fun sendAuthentication(requestLogin : LoginRequest)
    }
}