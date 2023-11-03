package com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel

data class GetFavoriteProductsState (
    val isLoading : Boolean = false,
    val error : String? =  null,
    val favoriteProducts : List<FavoriteProductModel>? = null
)