package com.leventsurer.ecommerceappwithcompose.domain.use_case.login

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.request.LoginRequest
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.LoginResponse
import com.leventsurer.ecommerceappwithcompose.domain.repository.AuthenticationRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    fun executeLogin(loginRequest: LoginRequest):Flow<Resource<LoginResponse>> = flow {
        try {
            emit(Resource.Loading())
            val result = authenticationRepository.login(loginRequest)
            emit(Resource.Success(result))
        }catch (e:Exception){
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}