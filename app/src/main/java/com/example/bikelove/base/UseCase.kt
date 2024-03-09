package com.example.bikelove.base

import com.example.bikelove.utils.ApiHandler
import com.example.bikelove.utils.BaseErrorBody
import com.example.bikelove.utils.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

/**
 * Executes business logic synchronously or asynchronously using Coroutines.
 */
abstract class UseCase<in P, R : Any, Error: BaseErrorBody>(private val coroutineDispatcher: CoroutineDispatcher): ApiHandler {

    /** Executes the use case asynchronously and returns a [Result].
     *
     * @return a [Result].
     *
     * @param parameters the input parameters to run the use case with
     */
    suspend operator fun invoke(parameters: P): NetworkResult<R> {
        return withContext(coroutineDispatcher) {
                handleApi {
                    execute(parameters)
                }
            }

    }
    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): Response<R>
}