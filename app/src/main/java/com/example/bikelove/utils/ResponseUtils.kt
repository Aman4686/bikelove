package com.example.bikelove.utils

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody


object ResponseUtils {

    fun getErrorResponse(response: ResponseBody?): ErrorBody {
        val responseString = response?.string() ?: throw IllegalStateException("ErrorResponse body is null")
        return Gson().fromJson(responseString, ErrorBody::class.java)
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

