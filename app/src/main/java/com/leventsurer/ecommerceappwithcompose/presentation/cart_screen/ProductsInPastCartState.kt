package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen

import com.leventsurer.ecommerceappwithcompose.domain.model.PastCart

data class ProductsInPastCartState (
    val isLoading : Boolean = false,
    val error : String? = null,
    val pastCarts : ArrayList<PastCart> = arrayListOf()
)