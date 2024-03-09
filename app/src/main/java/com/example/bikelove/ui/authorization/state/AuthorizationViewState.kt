package com.example.bikelove.ui.authorization.state

sealed class AuthorizationViewState

data class DisplayAuthorizationViewState(
    val authorizationErrorMessage: String?,
) : AuthorizationViewState()
object SuccessAuthorizationViewState : AuthorizationViewState()

object LoadingAuthorizationViewState : AuthorizationViewState()

data class ErrorAuthorizationViewState(val message: String?) : AuthorizationViewState()