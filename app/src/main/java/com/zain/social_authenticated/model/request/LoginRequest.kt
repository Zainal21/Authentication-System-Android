package com.zain.social_authenticated.model.request

data class LoginRequest(
    var username : String? = "",
    var password : String? = "",
)
