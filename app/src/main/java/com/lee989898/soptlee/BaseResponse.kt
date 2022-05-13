package com.lee989898.soptlee

data class BaseResponse<T>(
    val status: Int,
    val message: String,
    val data: T
)