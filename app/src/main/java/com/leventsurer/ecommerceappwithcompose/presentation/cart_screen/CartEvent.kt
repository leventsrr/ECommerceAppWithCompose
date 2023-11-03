package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen

sealed class CartEvent {
    object GetPastCarts:CartEvent()
    object GetCurrentCart:CartEvent()
}