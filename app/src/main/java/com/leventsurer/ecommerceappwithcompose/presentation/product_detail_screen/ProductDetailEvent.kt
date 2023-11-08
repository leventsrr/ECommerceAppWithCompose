package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel

sealed class ProductDetailEvent {

    data class GetProductDetailById(val productId:String) : ProductDetailEvent()

    data class AddProductToCart(val productInCartModel: ProductInCartModel): ProductDetailEvent()

    data class DeleteProductFromCart(val productInCartModel: ProductInCartModel) : ProductDetailEvent()

    data class AddProductToFavorites(val favoriteProductModel: FavoriteProductModel):ProductDetailEvent()
    data class RemoveProductToFavorites(val favoriteProductModel: FavoriteProductModel):ProductDetailEvent()

}