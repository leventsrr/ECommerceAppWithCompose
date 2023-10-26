package com.leventsurer.ecommerceappwithcompose.data.repository

import com.leventsurer.ecommerceappwithcompose.data.remote.AuthenticationApi
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.request.LoginRequest
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.LoginResponse
import com.leventsurer.ecommerceappwithcompose.domain.repository.AuthenticationRepository
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationApi:AuthenticationApi
) : AuthenticationRepository {
    override suspend fun login(loginRequest: LoginRequest) :LoginResponse{
        return authenticationApi.login(loginRequest)
    }
}