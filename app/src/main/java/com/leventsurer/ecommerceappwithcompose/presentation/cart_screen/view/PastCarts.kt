package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.PastCartState
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable.CartProductCard

@Composable
fun PastCarts(
    cartViewModelState:PastCartState
) {
    if (cartViewModelState.isLoading) {
        CircularProgressIndicator()
    } else if (!cartViewModelState.pastCarts.isNullOrEmpty()) {
        LazyColumn() {
            items(12) {
                Text("asada")
            }
        }
    }
}