package com.lee989898.soptlee

data class ResponseSignUp(
    val status: Int,
    val messages: String,
    val data: SignUpData
)

data class SignUpData(
    val id: Int
)
