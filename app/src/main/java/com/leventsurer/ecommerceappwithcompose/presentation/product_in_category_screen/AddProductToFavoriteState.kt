package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen

data class AddProductToFavoriteState(
    val isLoading : Boolean?  =null,
    val error :String?=null,
    val result : Boolean? = null,
)
