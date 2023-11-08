package com.leventsurer.ecommerceappwithcompose.presentation.home_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel

sealed class ProductsInCategoryEvent {

    data class GetProductInProductsInCategory(val categoryName:String):ProductsInCategoryEvent()

    data class AddProductToCart(val favoriteProductModel: FavoriteProductModel):ProductsInCategoryEvent()

    object GetFavoriteProducts:ProductsInCategoryEvent()
}
