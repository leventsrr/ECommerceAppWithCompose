package com.leventsurer.ecommerceappwithcompose.presentation.splash_screen

data class SplashScreenState(
    val error:String? = null,
    val isLoading: Boolean = false,
    val result: Boolean = false
)