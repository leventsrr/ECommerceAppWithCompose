package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen

data class DeleteProductFromCurrentCartState(
    val isLoading:Boolean?=null,
    val error:String?=null,
    val result:Boolean?=false
)
