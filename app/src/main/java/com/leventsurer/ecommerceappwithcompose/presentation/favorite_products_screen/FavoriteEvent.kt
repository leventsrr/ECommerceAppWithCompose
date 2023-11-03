package com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel

sealed class FavoriteEvent {
    object GetFavoriteProducts:FavoriteEvent()
    data class DeleteFavoriteProduct(val favoriteProductModel: FavoriteProductModel):FavoriteEvent()
}