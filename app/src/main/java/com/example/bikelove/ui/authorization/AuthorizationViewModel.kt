package com.example.bikelove.ui.authorization

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.model.register.RegisterRequestBody
import com.example.bikelove.cloud.authorization.useCase.LoginUseCase
import com.example.bikelove.cloud.authorization.useCase.RegistrationUseCase
import com.example.bikelove.ui.authorization.state.AuthorizationViewEvent
import com.example.bikelove.ui.authorization.state.AuthorizationViewState
import com.example.bikelove.ui.authorization.state.DisplayAuthorizationViewState
import com.example.bikelove.ui.authorization.state.LoadingAuthorizationViewState
import com.example.bikelove.ui.authorization.state.SuccessAuthorizationViewState
import com.example.bikelove.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

private const val TAG = "AuthorizationViewModel"

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val registrationUseCase: RegistrationUseCase,
) : ViewModel() {

    val authorizationViewStateFlow: StateFlow<AuthorizationViewState> get() = _authorizationViewStateFlow
    private val _authorizationViewStateFlow = MutableStateFlow<AuthorizationViewState>(
        LoadingAuthorizationViewState
    )

    fun obtainEvent(event: AuthorizationViewEvent) {
        when (event) {
            is AuthorizationViewEvent.Initial -> initialize()
            is AuthorizationViewEvent.Login -> login(phone = event.phone, password = event.password)
            is AuthorizationViewEvent.Register -> register(phone = event.phone, password = event.password)
        }
    }

    private fun login(phone: String, password: String) {
        if(phone.isEmpty() || password.isEmpty()) return

        viewModelScope.launch {
            val loginRequestBody = LoginRequestBody(
                phone = phone,
                password = password
            )
            val transactionResponse = loginUseCase(loginRequestBody)
            Log.d(TAG, "login: ${transactionResponse}")
            when (transactionResponse) {
                is NetworkResult.Success -> {
                    _authorizationViewStateFlow.value = SuccessAuthorizationViewState
                }
                is NetworkResult.Error -> {
                    _authorizationViewStateFlow.value = DisplayAuthorizationViewState(transactionResponse.errorMsg)
                }
                is NetworkResult.Exception -> {
                    _authorizationViewStateFlow.value = DisplayAuthorizationViewState("Something went wrong")
                }
                is NetworkResult.ErrorResponse -> {
                    _authorizationViewStateFlow.value = DisplayAuthorizationViewState(transactionResponse.errorBody.errorDescription)
                }
            }
        }
    }

    private fun register(phone: String, password: String) {
        if(phone.isEmpty() || password.isEmpty()) return

        viewModelScope.launch {
            val registerRequestBody = RegisterRequestBody(
                phone = phone,
                password = password
            )
            val transactionResponse = registrationUseCase(registerRequestBody)
            Log.d(TAG, "login: ${transactionResponse}")
            when (transactionResponse) {
                is NetworkResult.Success -> {
                    _authorizationViewStateFlow.value = SuccessAuthorizationViewState
                }
                is NetworkResult.Error -> {
                    _authorizationViewStateFlow.value = DisplayAuthorizationViewState(transactionResponse.errorMsg)
                }
                is NetworkResult.Exception -> {
                    _authorizationViewStateFlow.value = DisplayAuthorizationViewState("Something went wrong")
                }
                is NetworkResult.ErrorResponse -> {
                    _authorizationViewStateFlow.value = DisplayAuthorizationViewState(transactionResponse.errorBody.errorDescription)
                }
            }
        }
    }

    private fun initialize(){
        Log.d(TAG, "initialize")
        _authorizationViewStateFlow.value = DisplayAuthorizationViewState(null)
    }
}