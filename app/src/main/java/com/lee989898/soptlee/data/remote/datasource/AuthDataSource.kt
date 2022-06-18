package com.lee989898.soptlee.data.remote.datasource

import com.lee989898.soptlee.data.remote.model.auth.signin.RequestSignIn
import com.lee989898.soptlee.data.remote.model.auth.signin.ResponseSignIn
import com.lee989898.soptlee.data.remote.model.auth.signup.RequestSignUp
import com.lee989898.soptlee.data.remote.model.auth.signup.ResponseSignUp
import com.lee989898.soptlee.util.response.BaseResponse

interface AuthDataSource {

    suspend fun postSignIn(requestSignIn: RequestSignIn): BaseResponse<ResponseSignIn>
    suspend fun postSignUp(requestSignUp: RequestSignUp): BaseResponse<ResponseSignUp>
}