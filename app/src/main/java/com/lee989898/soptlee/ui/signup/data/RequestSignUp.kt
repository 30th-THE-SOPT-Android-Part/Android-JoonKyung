package com.lee989898.soptlee.ui.signup.data

import com.google.gson.annotations.SerializedName

data class RequestSignUp(
    val name: String,
    val email: String,
    val password: String
)