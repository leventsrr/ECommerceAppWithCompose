package com.leventsurer.ecommerceappwithcompose.presentation.login_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.request.LoginRequest
import com.leventsurer.ecommerceappwithcompose.domain.use_case.login.LoginUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel(){

    private val _loginState = mutableStateOf(LoginState())
    val loginState : State<LoginState> = _loginState
    private var job : Job? = null

    private fun login(loginRequest: LoginRequest){
        job = loginUseCase.executeLogin(loginRequest).onEach {
            when(it){
                is Resource.Loading ->{
                    _loginState.value = LoginState(isLoading = true)
                }
                is Resource.Error ->{
                    _loginState.value = LoginState(error = it.message)
                }
                is Resource.Success->{
                    _loginState.value = LoginState(result = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun loginOnEvent(loginEvent: LoginEvent){
        when(loginEvent){
            is LoginEvent.Login->{
                login(loginEvent.loginRequest)
            }
        }
    }


}