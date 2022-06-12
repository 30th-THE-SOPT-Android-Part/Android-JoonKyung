package com.lee989898.soptlee.data.remote.repository

import com.lee989898.soptlee.data.remote.datasource.AuthDataSource
import com.lee989898.soptlee.domain.repository.AuthRepository
import com.lee989898.soptlee.ui.signin.data.RequestSignIn
import com.lee989898.soptlee.ui.signin.data.ResponseSignIn
import com.lee989898.soptlee.ui.signup.data.RequestSignUp
import com.lee989898.soptlee.ui.signup.data.ResponseSignUp
import com.lee989898.soptlee.util.response.BaseResponse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
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
