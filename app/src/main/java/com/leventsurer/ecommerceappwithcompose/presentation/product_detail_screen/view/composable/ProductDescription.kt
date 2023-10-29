package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ProductDescription(productsDescription:String) {
    Column() {
        Text(text = "Description", fontWeight = FontWeight.Bold)
        Text(
            text = productsDescription, color = Color.Gray
        )
    }
}