package com.example.bikelove.cloud.authorization.useCase

import com.example.bikelove.base.UseCase
import com.example.bikelove.cloud.authorization.model.register.RegisterRequestBody
import com.example.bikelove.cloud.authorization.model.register.RegisterResponse
import com.example.bikelove.cloud.authorization.repository.AuthorizationRepository
import com.example.bikelove.di.IoDispatcher
import com.example.bikelove.storage.useCase.AuthorizationSharedPreferences
import com.example.bikelove.utils.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class RegistrationUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository,
    private val authorizationSharedPreferences: AuthorizationSharedPreferences,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<RegisterRequestBody, NetworkResult<RegisterResponse>>(dispatcher){

    override suspend fun execute(parameters: RegisterRequestBody): NetworkResult<RegisterResponse> {
        val result = authorizationRepository.register(parameters)

        if(result is NetworkResult.Success){
            result.data.accessToken?.let { token ->
                authorizationSharedPreferences.putToken(token)
            }
        }

        return result
    }
}