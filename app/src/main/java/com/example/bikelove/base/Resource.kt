package com.example.bikelove.base

import com.google.gson.annotations.SerializedName


sealed class Resource<T>(val data: T?, val message: String?, val errorResponse: com.example.bikelove.base.ErrorResponse?) {
    class Success<T>(data: T) : Resource<T>(data, null,null)
    class Error<T>(message: String) : Resource<T>(null, message,null)
    class ErrorResponse<T>(errorResponse: com.example.bikelove.base.ErrorResponse?) : Resource<T>(null, null, errorResponse)
}

data class ErrorResponse(
    @SerializedName("status")
    val status: Boolean?,
    @SerializedName("cause")
    val cause: String?,
    @SerializedName("message")
    val message: String?
)