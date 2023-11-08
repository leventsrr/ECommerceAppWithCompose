package com.leventsurer.ecommerceappwithcompose.presentation.home_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.ProductsInCategoryEvent

sealed class HomeEvent {

    object GetHomeScreenData : HomeEvent()
    data class SearchProductByName(val productName:String) : HomeEvent()
    object GetFavoriteProducts: HomeEvent()

    data class AddProductToFavorite(val favoriteProductModel: FavoriteProductModel):HomeEvent()

    data class RemoveProductFromFavorite(val favoriteProductModel: FavoriteProductModel):HomeEvent()


}