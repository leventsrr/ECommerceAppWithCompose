package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.ProductsInPastCartState
import com.leventsurer.ecommerceappwithcompose.tools.toFormattedDate

@Composable
fun PastCarts(
    productsInPastCartState: ProductsInPastCartState
) {


    if (productsInPastCartState.isLoading) {
        CircularProgressIndicator()
    } else if (productsInPastCartState.pastCarts.isNotEmpty()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(productsInPastCartState.pastCarts.size) { index ->
                var totalPrice = 0.0
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(5.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(5.dp) , horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column(

                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = productsInPastCartState.pastCarts[index].cartDate.toFormattedDate(
                                    "dd.MM.yyyy"
                                )
                                , modifier = Modifier.padding(bottom = 5.dp)
                            )
                            Row(modifier = Modifier.padding(bottom = 5.dp)) {
                                productsInPastCartState.pastCarts[index].products.forEach { product ->
                                    totalPrice += product.quantity * product.product.price.toDouble()
                                    Box {
                                        AsyncImage(
                                            contentScale = ContentScale.Fit,
                                            modifier = Modifier
                                                .width(40.dp)
                                                .height(40.dp)
                                                .clip(CircleShape)
                                                .align(Alignment.Center),
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(product.product.image)
                                                .crossfade(true)
                                                .build(),
                                            contentDescription = null,
                                        )
                                        Text(
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            text = "x${product.quantity}",
                                            color = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.BottomEnd)
                                                .background(Color.Black, CircleShape),
                                        )
                                    }
                                }

                            }
                            Text(text = "Total Price: $${String.format("%.2f", totalPrice)}")

                        }


                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                tint = Color.Black,
                                imageVector = Icons.Default.NavigateNext,
                                contentDescription = ""
                            )
                        }

                    }
                }
            }
        }
    }
}