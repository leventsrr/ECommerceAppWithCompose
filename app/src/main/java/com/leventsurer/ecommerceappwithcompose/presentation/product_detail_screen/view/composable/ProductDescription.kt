package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.leventsurer.ecommerceappwithcompose.R

@Composable
fun ProductDescription(productsDescription:String) {
    Column() {
        Text(text = stringResource(id = R.string.desctiption), fontWeight = FontWeight.Bold)
        Text(
            text = productsDescription, color = Color.Gray
        )
    }
}