package com.leventsurer.ecommerceappwithcompose.presentation.home_screen

sealed class HomeEvent {

    object GetHomeScreenData : HomeEvent()
    data class SearchProductByName(val productName:String) : HomeEvent()

}