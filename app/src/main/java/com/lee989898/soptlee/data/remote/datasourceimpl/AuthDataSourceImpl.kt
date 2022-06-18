package com.lee989898.soptlee.data.remote.datasourceimpl

import com.lee989898.soptlee.data.remote.datasource.AuthDataSource
import com.lee989898.soptlee.data.remote.api.AuthService
import com.lee989898.soptlee.data.remote.model.auth.signin.RequestSignIn
import com.lee989898.soptlee.data.remote.model.auth.signin.ResponseSignIn
import com.lee989898.soptlee.data.remote.model.auth.signup.RequestSignUp
import com.lee989898.soptlee.data.remote.model.auth.signup.ResponseSignUp
import com.lee989898.soptlee.util.response.BaseResponse
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthDataSource {

    override suspend fun postSignIn(requestSignIn: RequestSignIn): BaseResponse<ResponseSignIn> = authService.postSignIn(requestSignIn)

    override suspend fun postSignUp(requestSignUp: RequestSignUp): BaseResponse<ResponseSignUp> = authService.postSignUp(requestSignUp)
}