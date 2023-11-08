package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel

data class GetFavoritesProductsState(
    val isLoading : Boolean? = null,
    val error : String? = null,
    val favoriteProducts:List<FavoriteProductModel>? = null
)
