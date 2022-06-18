package com.lee989898.soptlee.data.remote.api

import com.lee989898.soptlee.data.remote.model.auth.signin.RequestSignIn
import com.lee989898.soptlee.util.response.BaseResponse
import com.lee989898.soptlee.data.remote.model.auth.signin.ResponseSignIn
import com.lee989898.soptlee.data.remote.model.auth.signup.RequestSignUp
import com.lee989898.soptlee.data.remote.model.auth.signup.ResponseSignUp
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST

interface AuthService {

    @POST("auth/signin")
    suspend fun postSignIn(
        @Body requestSignIn: RequestSignIn
    ): BaseResponse<ResponseSignIn>

    @Multipart
    @POST("auth/signup")
    suspend fun postSignUp(
        @Body requestSignUp: RequestSignUp
    ): BaseResponse<ResponseSignUp>
}