package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen

data class RemoveProductFromFavoriteState(
    val isLoading:Boolean? = null,
    val error:String? = null,
    val result :Boolean = false
)
