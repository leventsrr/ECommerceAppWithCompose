package com.leventsurer.ecommerceappwithcompose.presentation.login_screen

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.LoginResponse
import com.leventsurer.ecommerceappwithcompose.tools.Resource

data class LoginState(
    val error:String? = null,
    val isLoading: Boolean = false,
    val result:LoginResponse? = null
)
