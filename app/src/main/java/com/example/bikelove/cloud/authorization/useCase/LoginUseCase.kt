package com.example.bikelove.cloud.authorization.useCase

import com.example.bikelove.base.UseCase
import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.model.login.LoginResponse
import com.example.bikelove.cloud.authorization.repository.AuthorizationRepository
import com.example.bikelove.di.IoDispatcher
import com.example.bikelove.storage.useCase.AuthorizationSharedPreferences
import com.example.bikelove.utils.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository,
    private val authorizationSharedPreferences: AuthorizationSharedPreferences,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<LoginRequestBody, NetworkResult<LoginResponse>>(dispatcher){

    override suspend fun execute(parameters: LoginRequestBody): NetworkResult<LoginResponse> {
        val result = authorizationRepository.login(parameters)

        if(result is NetworkResult.Success){
            result.data.accessToken?.let { token ->
                authorizationSharedPreferences.putToken(token)
            }
        }

        return result
    }
}