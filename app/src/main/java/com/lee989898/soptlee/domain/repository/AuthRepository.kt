package com.lee989898.soptlee.domain.repository

import com.google.gson.annotations.SerializedName
import com.lee989898.soptlee.ui.signin.data.RequestSignIn
import com.lee989898.soptlee.ui.signin.data.ResponseSignIn
import com.lee989898.soptlee.ui.signup.data.RequestSignUp
import com.lee989898.soptlee.ui.signup.data.ResponseSignUp
import com.lee989898.soptlee.util.response.BaseResponse

interface AuthRepository {
    suspend fun postSignIn(
        requestSignIn: RequestSignIn
    ): Result<BaseResponse<ResponseSignIn>>

    suspend fun postSignUp(
        requestSignUp: RequestSignUp
    ): Result<BaseResponse<ResponseSignUp>>
}