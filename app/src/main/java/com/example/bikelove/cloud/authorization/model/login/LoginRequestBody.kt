package com.example.bikelove.cloud.authorization.model.login

import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    @SerializedName("phone")
    val phone: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("email")
    val email: String? = null,
)