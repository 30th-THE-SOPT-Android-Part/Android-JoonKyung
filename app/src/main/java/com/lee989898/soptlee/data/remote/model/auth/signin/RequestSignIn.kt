package com.lee989898.soptlee.data.remote.model.auth.signin

import com.google.gson.annotations.SerializedName

data class RequestSignIn(
    val email: String,
    val password: String
)