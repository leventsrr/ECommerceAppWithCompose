package com.leventsurer.ecommerceappwithcompose.domain.model

data class PastCart(
    val cartDate : String,
    val products : ArrayList<ProductWithQuantity>
)
