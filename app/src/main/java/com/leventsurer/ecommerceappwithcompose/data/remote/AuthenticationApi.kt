package com.leventsurer.ecommerceappwithcompose.data.remote

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.request.LoginRequest
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("auth/login")
    suspend fun login(@Body loginRequest:LoginRequest) : LoginResponse

}