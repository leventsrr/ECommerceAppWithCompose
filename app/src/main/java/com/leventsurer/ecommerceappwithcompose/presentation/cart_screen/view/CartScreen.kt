package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CartEvent
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CartViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable.SegmentedButton

@Composable
fun CartScreen(
    paddingValues: PaddingValues,
    cartViewModel: CartViewModel = hiltViewModel()
) {
    cartViewModel.getAllPastCartsState.value
    val currentCartViewModelState = cartViewModel.getCurrentCartState.value
    var selectedSegment by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            )
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.my_cart),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            SegmentedButton(
                selectedSegment = selectedSegment,
                onSegmentSelect = { selectedSegment = it })
        }
        Spacer(modifier = Modifier.height(5.dp))
        if (selectedSegment == 0) {
            LaunchedEffect(Unit) {
                cartViewModel.onEvent(CartEvent.GetCurrentCart)
            }
            CurrentCart(
                productRemoveFromCart = {
                    cartViewModel.onEvent(CartEvent.DeleteProductFromCurrentCart(it))
                    cartViewModel.onEvent(CartEvent.GetCurrentCart)
                },
                currentCartViewModelState = currentCartViewModelState,
            )
        } else if (selectedSegment == 1) {
            LaunchedEffect(Unit) {
                cartViewModel.onEvent(CartEvent.GetPastCarts)
            }
            PastCarts(cartViewModel.getPastCartsWithProducts.value)
        }
    }
}