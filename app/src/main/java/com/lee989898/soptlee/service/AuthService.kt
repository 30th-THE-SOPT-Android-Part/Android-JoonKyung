package com.lee989898.soptlee.service

import com.lee989898.soptlee.util.BaseResponse
import com.lee989898.soptlee.signin.data.RequestSignIn
import com.lee989898.soptlee.signin.data.ResponseSignIn
import com.lee989898.soptlee.signup.data.RequestSignUp
import com.lee989898.soptlee.signup.data.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/signin")
    fun postLogin(
        @Body body: RequestSignIn
    ): Call<BaseResponse<ResponseSignIn>>

    @POST("auth/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<BaseResponse<ResponseSignUp>>
}