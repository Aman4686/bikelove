package com.example.bikelove.cloud.authorization

import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.model.login.LoginResponse
import com.example.bikelove.cloud.authorization.model.login.LoginResult
import com.example.bikelove.utils.ApiHandler
import com.example.bikelove.utils.NetworkResult
import com.example.bikelove.utils.ResponseUtils
import retrofit2.Response
import javax.inject.Inject

class AuthorizationRepository @Inject constructor(private val authorizationAPI: AuthorizationAPI) {

    suspend fun login(loginRequestBody: LoginRequestBody) : Response<LoginResponse> {
        return authorizationAPI.login(loginRequestBody)
    }

}