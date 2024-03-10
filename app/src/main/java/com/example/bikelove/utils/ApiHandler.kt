package com.example.bikelove.utils

import android.util.Log
import com.example.bikelove.utils.ResponseUtils.getErrorResponse
import kotlinx.coroutines.CancellationException
import retrofit2.HttpException
import retrofit2.Response
private const val TAG = "ApiHandler"
interface ApiHandler {
    suspend fun <T : Any,> handleApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        return try {
            val response = execute()
            return if (response.isSuccessful) {
                NetworkResult.Success(response.code(), response.body()!!)
            } else {
                val errorBody = getErrorResponse(response.errorBody())
                NetworkResult.ErrorResponse(errorBody)
            }
        } catch (e: HttpException) {
            NetworkResult.Error(e.code(), e.message())
        } catch (e: CancellationException) {
            throw e
        }catch (e: Throwable) {
            NetworkResult.Exception(e)
        }
    }
}