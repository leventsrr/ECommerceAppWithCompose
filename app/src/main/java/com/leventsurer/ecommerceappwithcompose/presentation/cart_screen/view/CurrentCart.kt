package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CurrentCartState
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable.CartProductCard

@Composable
fun CurrentCart(
    currentCartViewModelState: CurrentCartState,
) {
    if (currentCartViewModelState.isLoading) {
        CircularProgressIndicator(color = Color.Black)
    } else if (currentCartViewModelState.currentCart!=null) {
        var totalPrice by remember{
            mutableDoubleStateOf(0.0)
        }
        val shippingPrice = 17
        val currentCartList = currentCartViewModelState.currentCart
        LaunchedEffect(Unit){
            currentCartList.forEach {  cart->
                totalPrice+=cart.productPrice.toDouble() * cart.productQuantity.toDouble()
            }
        }


        if(currentCartViewModelState.currentCart.isNotEmpty()){
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                currentCartViewModelState.currentCart.forEach { model ->
                    CartProductCard(model)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .border(1.dp, Color.LightGray, RoundedCornerShape(15.dp))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, start = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Subtotal", fontWeight = FontWeight.Bold)
                        Text(text = "$${String.format("%.2f",totalPrice)}", fontSize = 23.sp, fontWeight = FontWeight.Bold)

                    }
                    Divider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = stringResource(id = R.string.shipping), fontWeight = FontWeight.Bold)
                        Text(text = "$$shippingPrice", fontSize = 23.sp, fontWeight = FontWeight.Bold)
                    }
                    Divider()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 15.dp, start = 10.dp, end = 10.dp, top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = stringResource(id = R.string.bag_total), fontWeight = FontWeight.Bold)
                        Row (verticalAlignment = Alignment.CenterVertically){
                            Text(text = "(${currentCartViewModelState.currentCart.size}) ", color = Color.LightGray)
                            Text(text = "$${String.format("%.2f",totalPrice + shippingPrice)}", fontSize = 23.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.elevatedButtonColors(containerColor = Color.Black),
                    onClick = { /*TODO*/ }) {
                    Text(stringResource(id = R.string.proceed_to_check_out), color = Color.White)
                }
            }
        }else{
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.empty_cart_animation))

            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                LottieAnimation(
                    modifier = Modifier.fillMaxWidth(),
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                )
                Text(text = stringResource(id = R.string.empty_cart_warning), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = Color.LightGray)
            }
        }
    }
}