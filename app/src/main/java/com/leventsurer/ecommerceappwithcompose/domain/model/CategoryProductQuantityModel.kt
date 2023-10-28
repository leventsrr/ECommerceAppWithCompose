package com.leventsurer.ecommerceappwithcompose.domain.model

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

data class CategoryProductQuantityModel(
    val categoryName: String,
    val categoryQuantity:Int
)


