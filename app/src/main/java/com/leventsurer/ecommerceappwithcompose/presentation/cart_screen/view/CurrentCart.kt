package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CartViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.CurrentCartState
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable.CartProductCard

@Composable
fun CurrentCart(
    currentCartViewModelState: CurrentCartState,
    paddingValues: PaddingValues
) {
    if (currentCartViewModelState.isLoading) {
        CircularProgressIndicator()
    } else if (!currentCartViewModelState.currentCart.isNullOrEmpty()) {
        Column(
            modifier = Modifier
                .padding(bottom = paddingValues.calculateBottomPadding(),)
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
                    modifier = Modifier.fillMaxWidth().padding(top = 15.dp, start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Subtotal", fontWeight = FontWeight.Bold)
                    Text(text = "$483", fontSize = 23.sp, fontWeight = FontWeight.Bold)

                }
                Divider()
                Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Shipping", fontWeight = FontWeight.Bold)
                    Text(text = "$17", fontSize = 23.sp, fontWeight = FontWeight.Bold)


                }
                Divider()
                Row(
                    modifier = Modifier.fillMaxWidth().padding(bottom = 15.dp, start = 10.dp, end = 10.dp, top = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Bag Total", fontWeight = FontWeight.Bold)
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Text(text = "(3 item) ", color = Color.LightGray)
                        Text(text = "$483", fontSize = 23.sp, fontWeight = FontWeight.Bold)
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
                Text("Proceed to Checkout", color = Color.White)
            }
        }

    }
}