package com.example.bikelove.cloud.authorization.useCase


import com.example.bikelove.base.UseCase
import com.example.bikelove.cloud.authorization.AuthorizationRepository
import com.example.bikelove.cloud.authorization.model.login.LoginErrorBody
import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.model.login.LoginResponse
import com.example.bikelove.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Response
import javax.inject.Inject
class AuthorizationLoginUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<LoginRequestBody, LoginResponse, LoginErrorBody>(dispatcher) {

    override suspend fun execute(parameters: LoginRequestBody): Response<LoginResponse> {
        return authorizationRepository.login(parameters)
    }

}