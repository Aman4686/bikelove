package com.example.bikelove.ui.authorization.state

import com.example.bikelove.base.ErrorResponse

sealed class AuthorizationViewState

object DisplayAuthorizationViewState : AuthorizationViewState()

object LoadingAuthorizationViewState : AuthorizationViewState()

data class ErrorAuthorizationViewState(val message: String?) : AuthorizationViewState()

data class ErrorResponseAuthorizationViewState(val errorResponse: ErrorResponse?) : AuthorizationViewState()