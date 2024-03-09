package com.example.bikelove.ui.authorization

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bikelove.cloud.authorization.model.login.LoginErrorBody
import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.useCase.AuthorizationLoginUseCase
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

private const val TAG = "MainViewModel"

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authorizationLoginUseCase: AuthorizationLoginUseCase,
) : ViewModel() {

    val authorizationViewStateFlow: StateFlow<AuthorizationViewState> get() = _authorizationViewStateFlow
    private val _authorizationViewStateFlow = MutableStateFlow<AuthorizationViewState>(
        LoadingAuthorizationViewState
    )

    fun obtainEvent(event: AuthorizationViewEvent) {
        when (event) {
            is AuthorizationViewEvent.Initial -> initialize()
            is AuthorizationViewEvent.Login -> login(phone = event.phone, password = event.password)
        }
    }

    private fun login(phone: String, password: String) {
        viewModelScope.launch {
            val loginRequestBody = LoginRequestBody(
                phone = phone,
                password = password
            )
            when (val transactionResponse = authorizationLoginUseCase(loginRequestBody)) {
                is NetworkResult.Success -> {
                    _authorizationViewStateFlow.value = SuccessAuthorizationViewState
                }
                is NetworkResult.Error -> {
                    Log.d("fdsafdsaf", "login: ${transactionResponse}")
                    //val errorDescription = transactionResponse.errorBody?.errorDescription
                    _authorizationViewStateFlow.value = DisplayAuthorizationViewState(transactionResponse.errorMsg)
                }
                is NetworkResult.Exception -> {
                    _authorizationViewStateFlow.value = DisplayAuthorizationViewState("Something went wrong")
                }
            }
        }
    }

    private fun initialize(){
        _authorizationViewStateFlow.value = DisplayAuthorizationViewState(null)
    }
}