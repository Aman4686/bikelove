package com.example.bikelove.cloud.authorization.model.register

import com.google.gson.annotations.SerializedName

data class RegisterRequestBody(
    @SerializedName("phone")
    val phone: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("patronymic")
    val patronymic: String? = null,
    @SerializedName("email")
    val email: String? = null,
)