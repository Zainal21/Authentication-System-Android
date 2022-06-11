package com.zain.social_authenticated.model.response

data class LoginResponse(
    val success : Boolean? = false,
    val message : String? = "",
    val status : String? = "",
    val token : String? = "",
)
