package com.zain.social_authenticated.model.request

data class LoginRequest(
    val username : String? = "",
    val password : String? = "",
)
