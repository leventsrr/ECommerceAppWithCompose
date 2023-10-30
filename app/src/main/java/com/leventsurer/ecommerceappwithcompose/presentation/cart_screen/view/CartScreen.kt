package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CartEvent
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CartViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable.CartProductCard
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable.SegmentedButton

@Composable
fun CartScreen(
    paddingValues: PaddingValues,
    cartViewModel: CartViewModel = hiltViewModel()
) {

    val cartViewModelState = cartViewModel.getAllCartsState.value
    var selectedSegment by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = paddingValues.calculateTopPadding())
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Text(text = "My Cart", fontWeight = FontWeight.Bold, fontSize = 32.sp)
            SegmentedButton(selectedSegment = selectedSegment, onSegmentSelect = {selectedSegment = it})
        }
        Spacer(modifier = Modifier.height(5.dp))
        if(selectedSegment == 0){
            Text(text = "sdfsdf")
        }else if(selectedSegment == 1){
            LaunchedEffect(Unit) {
                cartViewModel.onEvent(CartEvent.GetPastCarts)
            }
            PastCarts(cartViewModelState = cartViewModelState)
            
        }
       


    }
}