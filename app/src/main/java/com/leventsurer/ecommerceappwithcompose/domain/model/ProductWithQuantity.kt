package com.leventsurer.ecommerceappwithcompose.domain.model

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

data class ProductWithQuantity(
    val product:GetProductResponse,
    val quantity:Int
)
