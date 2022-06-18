package com.lee989898.soptlee.data.remote.repository

import com.lee989898.soptlee.data.remote.datasource.AuthDataSource
import com.lee989898.soptlee.domain.repository.AuthRepository
import com.lee989898.soptlee.data.remote.model.auth.signin.RequestSignIn
import com.lee989898.soptlee.data.remote.model.auth.signin.ResponseSignIn
import com.lee989898.soptlee.data.remote.model.auth.signup.RequestSignUp
import com.lee989898.soptlee.data.remote.model.auth.signup.ResponseSignUp
import com.lee989898.soptlee.util.response.BaseResponse
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {

    override suspend fun postSignIn(
        requestSignIn: RequestSignIn
    ): Result<BaseResponse<ResponseSignIn>> = kotlin.runCatching {
        authDataSource.postSignIn(requestSignIn)
    }

    override suspend fun postSignUp(
        requestSignUp: RequestSignUp
    ): Result<BaseResponse<ResponseSignUp>> = kotlin.runCatching {
        authDataSource.postSignUp(requestSignUp)
    }
}
