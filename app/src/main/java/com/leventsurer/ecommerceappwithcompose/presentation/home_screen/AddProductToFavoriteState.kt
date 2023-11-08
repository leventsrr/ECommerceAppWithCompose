package com.leventsurer.ecommerceappwithcompose.presentation.home_screen

data class AddProductToFavoriteState(
    val isLoading:Boolean?=null,
    val error:String?=null,
    val result: Boolean?=null,
)
