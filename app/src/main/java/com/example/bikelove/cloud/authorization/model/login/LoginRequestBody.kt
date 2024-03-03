package com.example.bikelove.cloud.authorization.model.login

data class LoginRequestBody(
    val phone: String,
    val email: String?,
    val password: String
)