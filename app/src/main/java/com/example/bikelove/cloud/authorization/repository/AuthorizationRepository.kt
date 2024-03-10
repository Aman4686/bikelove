package com.example.bikelove.cloud.authorization.repository

import com.example.bikelove.cloud.authorization.AuthorizationAPI
import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.model.login.LoginResponse
import com.example.bikelove.cloud.authorization.model.register.RegisterRequestBody
import com.example.bikelove.cloud.authorization.model.register.RegisterResponse
import com.example.bikelove.utils.ApiHandler
import com.example.bikelove.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class AuthorizationRepository @Inject constructor(private val authorizationAPI: AuthorizationAPI): ApiHandler {

    suspend fun login(loginRequestBody: LoginRequestBody) : NetworkResult<LoginResponse> {
        return handleApi {
            authorizationAPI.login(loginRequestBody)
        }
    }
    suspend fun register(registerRequestBody: RegisterRequestBody) : NetworkResult<RegisterResponse> {
        return handleApi {
            authorizationAPI.register(registerRequestBody)
        }
    }

}