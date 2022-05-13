package com.lee989898.soptlee

import com.lee989898.soptlee.signin.RequestSignIn
import com.lee989898.soptlee.signin.ResponseSignIn
import com.lee989898.soptlee.signup.RequestSignUp
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