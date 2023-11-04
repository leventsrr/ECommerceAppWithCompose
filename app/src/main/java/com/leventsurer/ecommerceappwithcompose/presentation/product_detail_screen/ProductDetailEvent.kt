package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel

sealed class ProductDetailEvent {

    data class GetProductDetailById(val productId:String) : ProductDetailEvent()

    data class AddProductToCart(val productInCartModel: ProductInCartModel): ProductDetailEvent()

    data class DeleteProductFromCar(val productInCartModel: ProductInCartModel) : ProductDetailEvent()
}