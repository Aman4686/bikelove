package com.example.bikelove.cloud.authorization.model.register

import com.example.bikelove.cloud.authorization.model.login.LoginResponse
import com.google.gson.annotations.SerializedName

class RegisterResponse {
    @SerializedName("accessToken")
    var accessToken: String? = null
    @SerializedName("user")
    var user: LoginResponse.User? = null
}