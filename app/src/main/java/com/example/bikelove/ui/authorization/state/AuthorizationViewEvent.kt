package com.example.bikelove.ui.authorization.state

sealed class AuthorizationViewEvent{
    object Initial : AuthorizationViewEvent()
    data class Login(val phone: String,val password: String) : AuthorizationViewEvent()
    data class Register(val phone: String,val password: String) : AuthorizationViewEvent()
}
