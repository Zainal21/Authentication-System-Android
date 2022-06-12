package com.zain.social_authenticated.network

import com.zain.social_authenticated.model.request.LoginRequest
import com.zain.social_authenticated.model.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIInterface {
    @FormUrlEncoded
    @POST("v1/auth/login")
    fun authenticated(@Field("email") email: String,
                      @Field("password") password: String) : Observable<LoginResponse>
}