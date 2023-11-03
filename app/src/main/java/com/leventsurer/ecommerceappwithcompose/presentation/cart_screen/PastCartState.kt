package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetAllCartsResponse

data class PastCartState (
    val isLoading:Boolean = false,
    val error:String?=null,
    val pastCarts: ArrayList<GetAllCartsResponse>? = null
)