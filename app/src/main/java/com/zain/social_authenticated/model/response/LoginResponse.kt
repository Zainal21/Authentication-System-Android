package com.zain.social_authenticated.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LoginResponse(

	@field:SerializedName("result")
	val result: Result? = null,

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
){
	@Keep
	data class Result(
		@field:SerializedName("token")
		val token: String? = null
	)
}


