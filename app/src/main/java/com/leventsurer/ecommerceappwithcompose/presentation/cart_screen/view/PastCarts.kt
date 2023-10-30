package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CartState
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CartViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable.CartProductCard

@Composable
fun PastCarts(
    cartViewModelState:CartState
) {
    if (cartViewModelState.isLoading) {
        CircularProgressIndicator()
    } else if (!cartViewModelState.pastCarts.isNullOrEmpty()) {
        LazyColumn() {
            items(12) {
                CartProductCard()
            }
        }
    }
}