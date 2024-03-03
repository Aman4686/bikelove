package com.example.bikelove.utils

import com.example.bikelove.base.ErrorResponse
import com.google.gson.Gson

object ResponseUtils {

    fun getErrorResponse(response:String): ErrorResponse {
        return Gson().fromJson(response, ErrorResponse::class.java)
    }

}