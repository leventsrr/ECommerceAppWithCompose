package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen

data class ProductCartTransactionsState(
    val isLoading : Boolean = false,
    val error : String? = null,
    val result : Boolean? = null
)
