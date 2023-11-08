package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel

sealed class CartEvent {
    object GetPastCarts:CartEvent()
    object GetCurrentCart:CartEvent()

    data class DeleteProductFromCurrentCart(val productInCartModel: ProductInCartModel):CartEvent()

}