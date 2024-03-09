package com.example.bikelove.utils

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody


object ResponseUtils {

    inline fun <reified ERROR: BaseErrorBody> getErrorResponse(response: ResponseBody?): ERROR {
        val responseString = response?.string() ?: throw IllegalStateException("ErrorResponse body is null")
        return Gson().fromJson(responseString, ERROR::class.java)
    }
    data class ErrorResponse(
        @SerializedName("status")
        val status: Boolean?,
        @SerializedName("cause")
        val cause: String?,
        @SerializedName("message")
        val message: String?
    )
}

