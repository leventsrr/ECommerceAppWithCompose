package com.leventsurer.ecommerceappwithcompose.presentation.splash_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_store.GetUserLoginStatusUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val getUserLoginStateUseCase: GetUserLoginStatusUseCase
) :ViewModel(){

    private val _userIsLoginState = mutableStateOf(SplashScreenState())
    val userIsLoginState : State<SplashScreenState> = _userIsLoginState

    private var job:Job? = null

    fun getUserLoginStatus(){
        job?.cancel()
        job = getUserLoginStateUseCase.executeGetUserLoginStatus().onEach {
            when(it){
                is Resource.Loading ->{
                    _userIsLoginState.value = SplashScreenState(isLoading = true)
                }
                is Resource.Error ->{
                    _userIsLoginState.value = SplashScreenState(error = it.message)
                }
                is Resource.Success ->{
                    _userIsLoginState.value = SplashScreenState(result = it.data ?: false)
                }
            }
        }.launchIn(viewModelScope)
    }
}