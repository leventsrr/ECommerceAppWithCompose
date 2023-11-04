package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel

data class CurrentCartState(
    val isLoading : Boolean = false,
    val error : String? = null,
    val currentCart : List<ProductInCartModel>? = null
)
