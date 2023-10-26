package com.leventsurer.ecommerceappwithcompose.domain.repository

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.request.LoginRequest
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.LoginResponse

interface AuthenticationRepository {

    suspend fun login(loginRequest: LoginRequest) : LoginResponse
}