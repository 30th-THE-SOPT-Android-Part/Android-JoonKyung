package com.lee989898.soptlee.signup.data

import com.google.gson.annotations.SerializedName

data class RequestSignUp(
    val name: String,
    @SerializedName("email")
    val id: String,
    val password: String
)