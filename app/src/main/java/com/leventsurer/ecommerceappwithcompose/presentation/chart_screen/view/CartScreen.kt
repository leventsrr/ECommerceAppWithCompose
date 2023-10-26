package com.leventsurer.ecommerceappwithcompose.presentation.chart_screen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductQuantity

@Composable
fun CartScreen() {

    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Text(text = "My Cart", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn() {
            items(12) {
                Card(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 5.dp)
                        .fillMaxWidth()
                        .height(90.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Row(modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                        verticalAlignment = Alignment.Bottom) {
                        Image(
                            painter = painterResource(id = R.drawable.model1),
                            contentDescription = "",
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .clip(RoundedCornerShape(15.dp))
                        )

                        Column(modifier = Modifier
                            .fillMaxHeight()
                            .weight(5f), verticalArrangement = Arrangement.SpaceBetween) {
                            Column {
                                Text(text = "Macbook Air", fontWeight = FontWeight.Bold)
                                Text(text = "Apple", fontWeight = FontWeight.Light)
                            }

                            Text(text = "$1500.0", fontWeight = FontWeight.Bold)
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.LightGray.copy(0.6f))
                                .width(80.dp)
                                
                        ) {
                            Icon(painter = painterResource(id = R.drawable.baseline_remove_24), contentDescription ="add" , modifier = Modifier
                                .align(
                                    Alignment.CenterStart
                                )
                                .padding(start = 5.dp, top = 5.dp, bottom = 5.dp))
                            Text(text = "2", modifier = Modifier
                                .align(
                                    Alignment.Center
                                )
                                .padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 10.dp))
                            Icon(imageVector = Icons.Default.Add, contentDescription ="add", modifier = Modifier
                                .align(
                                    Alignment.CenterEnd
                                )
                                .padding(end = 5.dp, top = 5.dp, bottom = 5.dp) )
                        }
                        
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
        }

    }
}