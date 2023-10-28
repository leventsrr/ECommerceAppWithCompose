package com.leventsurer.ecommerceappwithcompose.data.remote.dto.response

import com.leventsurer.ecommerceappwithcompose.domain.model.CategoryProductQuantityModel

data class GetProductResponse(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: String,
    val title: String
)


