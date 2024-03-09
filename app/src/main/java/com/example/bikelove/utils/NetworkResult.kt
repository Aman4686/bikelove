package com.example.bikelove.utils

sealed class NetworkResult<out T : Any> {
    data class Success<out T : Any>(val code: Int, val data: T) : NetworkResult<T>()
    data class Error<T : String>(val code: Int, val errorMsg: String?) : NetworkResult<T>()
    data class Exception(val e: Throwable) : NetworkResult<Nothing>()
}
