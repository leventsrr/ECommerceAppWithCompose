package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CartViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CurrentCartState
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable.CartProductCard

@Composable
fun CurrentCart(
    currentCartViewModelState:CurrentCartState
) {
    if (currentCartViewModelState.isLoading) {
        CircularProgressIndicator()
    } else if (!currentCartViewModelState.currentCart.isNullOrEmpty()) {
        LazyColumn() {
            items(currentCartViewModelState.currentCart.size) {
                CartProductCard(currentCartViewModelState.currentCart[it])
            }
        }
    }
}