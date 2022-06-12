package com.lee989898.soptlee.data.remote.api

import com.lee989898.soptlee.ui.signin.data.RequestSignIn
import com.lee989898.soptlee.util.response.BaseResponse
import com.lee989898.soptlee.ui.signin.data.ResponseSignIn
import com.lee989898.soptlee.ui.signup.data.RequestSignUp
import com.lee989898.soptlee.ui.signup.data.ResponseSignUp
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PartMap

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