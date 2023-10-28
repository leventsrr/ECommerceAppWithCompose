package com.leventsurer.ecommerceappwithcompose.presentation.home_screen

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

data class NewArrivalProductsState (
    val isLoading : Boolean = false,
    val error : String? = null,
    val newArrivalProducts: ArrayList<GetProductResponse>? = null,
)