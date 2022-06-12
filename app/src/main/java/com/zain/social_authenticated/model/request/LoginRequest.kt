package com.zain.social_authenticated.model.request

import androidx.annotation.Keep

@Keep
data class LoginRequest(
    var username : String? = "",
    var password : String? = "",
)
