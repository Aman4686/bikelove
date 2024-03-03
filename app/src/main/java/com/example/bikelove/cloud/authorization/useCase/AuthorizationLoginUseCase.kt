package com.example.bikelove.cloud.authorization.useCase

import com.example.bikelove.base.Resource
import com.example.bikelove.base.UseCase
import com.example.bikelove.cloud.authorization.AuthorizationRepository
import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.model.login.LoginResult
import com.example.bikelove.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

class AuthorizationLoginUseCase @Inject constructor(
    private val authorizationRepository: AuthorizationRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<LoginRequestBody, Resource<LoginResult>>(dispatcher) {

    override suspend fun execute(loginRequestBody: LoginRequestBody): Resource<LoginResult> {
        return authorizationRepository.login(loginRequestBody)
    }

}