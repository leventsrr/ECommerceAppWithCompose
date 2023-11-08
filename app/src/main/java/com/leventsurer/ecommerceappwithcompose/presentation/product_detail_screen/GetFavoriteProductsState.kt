package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel

data class GetFavoriteProductsState(
    val isLoading: Boolean? = null,
    val error: String? = null,
    val result: List<FavoriteProductModel>? = null
)
