package com.example.bikelove.cloud.authorization

import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.model.login.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthorizationAPI {

    @POST("api/auth/login")
    suspend fun login(@Body loginRequestBody: LoginRequestBody) : Response<LoginResponse>

}