package com.example.bikelove.base

import com.example.bikelove.utils.ApiHandler
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Executes business logic synchronously or asynchronously using Coroutines.
 */
abstract class UseCase<in P, R : Any>(private val coroutineDispatcher: CoroutineDispatcher): ApiHandler {

    /** Executes the use case asynchronously and returns a [Result].
     *
     * @return a [Result].
     *
     * @param parameters the input parameters to run the use case with
     */
    suspend operator fun invoke(parameters: P): R {
        return withContext(coroutineDispatcher) {
                execute(parameters)
            }
    }
    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): R
}