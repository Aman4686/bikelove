package com.example.bikelove.ui.authorization
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bikelove.base.Resource
import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.model.login.LoginResult
import com.example.bikelove.cloud.authorization.useCase.AuthorizationLoginUseCase
import com.example.bikelove.ui.authorization.state.AuthorizationViewEvent
import com.example.bikelove.ui.authorization.state.AuthorizationViewState
import com.example.bikelove.ui.authorization.state.DisplayAuthorizationViewState
import com.example.bikelove.ui.authorization.state.ErrorAuthorizationViewState
import com.example.bikelove.ui.authorization.state.ErrorResponseAuthorizationViewState
import com.example.bikelove.ui.authorization.state.InitialAuthorizationViewState
import com.example.bikelove.ui.authorization.state.LoadingAuthorizationViewState
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
        when (val currentState = _authorizationViewStateFlow.value) {
            is LoadingAuthorizationViewState -> handleLoadingState(event)
        }
    }

    private fun handleLoadingState(event: AuthorizationViewEvent) {
        when (event) {
            is InitialAuthorizationViewState -> initialize()
        }
    }

    private suspend fun login(loginRequestBody: LoginRequestBody) : LoginResult? {
        val transactionResult = authorizationLoginUseCase(loginRequestBody).getOrElse {
            _authorizationViewStateFlow.value = ErrorAuthorizationViewState(it.message)
            null
        }
        transactionResult?.let {
            return@let when(it){
                is Resource.Success -> {
                    _authorizationViewStateFlow.value = DisplayAuthorizationViewState
                }
                is Resource.ErrorResponse -> {
                    _authorizationViewStateFlow.value = ErrorResponseAuthorizationViewState(
                        errorResponse = it.errorResponse
                    )
                }
                is Resource.Error -> {
                    _authorizationViewStateFlow.value = ErrorAuthorizationViewState(
                        message = it.message
                    )
                }
            }
        }
        return null
    }

    private fun initialize(){
        viewModelScope.launch {
            _authorizationViewStateFlow.value =
               DisplayAuthorizationViewState
        }
    }
}