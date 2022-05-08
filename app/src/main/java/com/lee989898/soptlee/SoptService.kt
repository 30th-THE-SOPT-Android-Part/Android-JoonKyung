package com.lee989898.soptlee

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {

    @POST("auth/signin")
    fun postLogin(
        @Body body: RequestSignIn
    ): Call<ResponseSignIn>


    @POST("auth/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>
}