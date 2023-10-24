package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ProductSize() {

    val productColors = arrayListOf(Color.White, Color.Black,Color.Green,Color.Red)


    Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)) {
        Column() {
            Text(text = "Size", fontWeight = FontWeight.Bold)
            Row() {
                OutlinedIconButton(

                    onClick = { /*TODO*/ }) {
                    Text(text = "S", fontWeight = FontWeight.Bold, color = Color.Gray)
                }
                OutlinedIconButton(
                    onClick = { /*TODO*/ }) {
                    Text(text = "M", fontWeight = FontWeight.Bold, color = Color.Gray)
                }
                OutlinedIconButton(
                    onClick = { /*TODO*/ }) {
                    Text(text = "L", fontWeight = FontWeight.Bold, color = Color.Gray)
                }
                OutlinedIconButton(
                    onClick = { /*TODO*/ }) {
                    Text(text = "XL", fontWeight = FontWeight.Bold, color = Color.Gray)
                }
                OutlinedIconButton(
                    onClick = { /*TODO*/ }) {
                    Text(text = "XXL", fontWeight = FontWeight.Bold, color = Color.Gray)
                }
            }
        }
        Card(elevation = CardDefaults.cardElevation(15.dp), shape = CircleShape, colors = CardDefaults.cardColors(containerColor = Color.White)) {
            Column(modifier = Modifier.padding(5.dp)) {
                for(i in 0 until productColors.size){
                    Box(
                        modifier = Modifier
                            .width(25.dp)
                            .aspectRatio(1f)
                            .background(
                                productColors[i],
                                shape = CircleShape
                            )
                            .border(1.dp, Color.LightGray, CircleShape)
                            
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }


            }
        }

    }

}