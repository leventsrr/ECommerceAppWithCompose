package com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen

data class DeleteFavoriteProductState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val result: Boolean? = null
)