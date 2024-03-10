package com.example.bikelove.utils

import com.google.gson.annotations.SerializedName

data class ErrorBody(

    @SerializedName("error") var error: String? = null,
    @SerializedName("errorDescription") var errorDescription: String? = null,
    @SerializedName("reasonField") var reasonField: String? = null
)