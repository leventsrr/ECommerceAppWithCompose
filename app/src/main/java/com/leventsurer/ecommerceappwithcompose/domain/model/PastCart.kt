package com.leventsurer.ecommerceappwithcompose.domain.model

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

data class PastCart(
    val cartDate : String,
    val products : ArrayList<ProductWithQuantity>
)
