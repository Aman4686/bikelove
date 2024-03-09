package com.example.bikelove.cloud.authorization.model.login

import com.example.bikelove.utils.BaseErrorBody
import com.google.gson.annotations.SerializedName

data class LoginErrorBody (
    @SerializedName("error")
    var error: String? = null,
    @SerializedName("errorDescription")
    var errorDescription: String? = null,
    @SerializedName("reasonField")
    var reasonField: String? = null
) : BaseErrorBody