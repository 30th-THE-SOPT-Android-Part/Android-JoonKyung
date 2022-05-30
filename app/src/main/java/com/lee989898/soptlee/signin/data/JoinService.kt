package com.lee989898.soptlee.signin.data

import com.lee989898.soptlee.BaseResponse
import com.lee989898.soptlee.ResponseSignUp
import com.lee989898.soptlee.signup.RequestSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface JoinService {

    @POST("auth/signin")
    fun postLogin(
        @Body body: RequestSignIn
    ): Call<BaseResponse<ResponseSignIn>>


    @POST("auth/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<BaseResponse<ResponseSignUp>>
}