package com.leventsurer.ecommerceappwithcompose.presentation.login_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.request.LoginRequest
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_store.SetUserLoginStatusUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.login.LoginUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val setIsLoginDataStoreUseCase: SetUserLoginStatusUseCase
) : ViewModel() {

    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> = _loginState

    private fun login(loginRequest: LoginRequest) {
        combine(
            loginUseCase.executeLogin(loginRequest),
            setIsLoginDataStoreUseCase.executeSetUserLoginStatus(true)
        ) { loginUseCaseResource, setIsLoginDataStoreUseCase ->
            when {
                loginUseCaseResource is Resource.Loading || setIsLoginDataStoreUseCase is Resource.Loading -> {
                    _loginState.value = LoginState(isLoading = true)
                }
                loginUseCaseResource is Resource.Success && setIsLoginDataStoreUseCase is Resource.Success -> {
                    val loginUseCaseData = loginUseCaseResource.data
                    _loginState.value = LoginState(result = loginUseCaseData)
                }
                loginUseCaseResource is Resource.Error -> {
                    _loginState.value = LoginState(error = loginUseCaseResource.message)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun loginOnEvent(loginEvent: LoginEvent) {
        when (loginEvent) {
            is LoginEvent.Login -> {
                login(loginEvent.loginRequest)
            }
        }
    }
}