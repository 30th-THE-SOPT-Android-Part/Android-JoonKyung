package com.lee989898.soptlee.data.remote.datasourceimpl

import com.lee989898.soptlee.data.remote.datasource.AuthDataSource
import com.lee989898.soptlee.data.remote.api.AuthService
import com.lee989898.soptlee.ui.signin.data.RequestSignIn
import com.lee989898.soptlee.ui.signin.data.ResponseSignIn
import com.lee989898.soptlee.ui.signup.data.RequestSignUp
import com.lee989898.soptlee.ui.signup.data.ResponseSignUp
import com.lee989898.soptlee.util.response.BaseResponse
import okhttp3.RequestBody
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthDataSource {

    override suspend fun postSignIn(requestSignIn: RequestSignIn): BaseResponse<ResponseSignIn> = authService.postSignIn(requestSignIn)

    override suspend fun postSignUp(requestSignUp: RequestSignUp): BaseResponse<ResponseSignUp> = authService.postSignUp(requestSignUp)
}