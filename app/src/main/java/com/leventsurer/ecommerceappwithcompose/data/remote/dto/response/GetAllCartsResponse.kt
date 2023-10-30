package com.leventsurer.ecommerceappwithcompose.data.remote.dto.response

data class GetAllCartsResponse(
    val date: String,
    val id: Int,
    val products: List<Product>,
    val userId: Int
)