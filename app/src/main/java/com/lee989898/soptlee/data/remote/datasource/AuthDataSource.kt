package com.lee989898.soptlee.data.remote.datasource

import com.lee989898.soptlee.ui.signin.data.RequestSignIn
import com.lee989898.soptlee.ui.signin.data.ResponseSignIn
import com.lee989898.soptlee.ui.signup.data.RequestSignUp
import com.lee989898.soptlee.ui.signup.data.ResponseSignUp
import com.lee989898.soptlee.util.response.BaseResponse
import okhttp3.RequestBody

interface AuthDataSource {
    suspend fun postSignIn(requestSignIn: RequestSignIn): BaseResponse<ResponseSignIn>

    suspend fun postSignUp(requestSignUp: RequestSignUp): BaseResponse<ResponseSignUp>
}