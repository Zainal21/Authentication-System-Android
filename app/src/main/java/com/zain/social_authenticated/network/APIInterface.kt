package com.zain.social_authenticated.network

import com.zain.social_authenticated.model.request.LoginRequest
import com.zain.social_authenticated.model.response.LoginResponse
import io.reactivex.Flowable
import io.reactivex.Observer
import retrofit2.http.Body

interface APIInterface {
    fun authenticated(@Body request: LoginRequest) : Flowable<LoginResponse>
}