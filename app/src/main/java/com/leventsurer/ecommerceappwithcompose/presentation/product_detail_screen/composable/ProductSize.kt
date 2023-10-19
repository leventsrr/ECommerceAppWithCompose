package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ProductSize() {
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
}