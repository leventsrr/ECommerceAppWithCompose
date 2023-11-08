package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel

sealed class ProductsInCategoryEvent {
    data class GetProductInProductsInCategory(val categoryName:String):ProductsInCategoryEvent()
    data class AddProductToCart(val favoriteProductModel: FavoriteProductModel):ProductsInCategoryEvent()
    data class RemoveProductFromFavorite(val favoriteProductModel: FavoriteProductModel):ProductsInCategoryEvent()
    object GetFavoriteProducts:ProductsInCategoryEvent()
}