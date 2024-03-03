package com.example.bikelove.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Executes business logic synchronously or asynchronously using Coroutines.
 */
abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    /** Executes the use case asynchronously and returns a [Result].
     *
     * @return a [Result].
     *
     * @param parameters the input parameters to run the use case with
     */
    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    Result.success(it)
                }
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
//    suspend operator fun invoke(parameters: P): Resource<R> {
//        return try {
//            withContext(coroutineDispatcher) {
//                if(parameters is Response<*>){
//                    if (parameters.isSuccessful && parameters.body() != null) {
//                        execute(parameters).let {
//                            Resource.Success(it)
//                        }
//                    } else {
//                        //Handling api error response (501, 404)
//                        Resource.ErrorResponse(ResponseUtils.getErrorResponse(parameters.errorBody()!!.string()))
//
//                    }
//                }else{
//                    execute(parameters).let {
//                        Resource.Success(it)
//                    }
//                }
//            }
//        } catch (e: Exception) {
//            Resource.Error(e.message ?: "An error occured")
//        }
//    }
    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}