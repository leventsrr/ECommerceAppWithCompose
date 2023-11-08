package com.leventsurer.ecommerceappwithcompose.data.remote.dto.response

data class GetProductResponse(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: String,
    val title: String,
    val rating: Rating,
)


