package com.leventsurer.ecommerceappwithcompose.presentation.login_screen

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.request.LoginRequest

sealed class LoginEvent {
    data class Login(val loginRequest : LoginRequest): LoginEvent()
}