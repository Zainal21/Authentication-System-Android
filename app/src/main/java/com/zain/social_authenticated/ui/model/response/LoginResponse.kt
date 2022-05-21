package com.zain.social_authenticated.ui.model.response

data class LoginResponse(
    val message : String? = "",
    val status : String? = "",
    val token : String? = "",
)
