package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

data class ProductDetailState (
    val isLoading : Boolean = false,
    val error : String? = null,
    val productDetail : GetProductResponse? = null
)