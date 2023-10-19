package com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.composable.CategoryCard

@Composable
fun CategoriesScreen(padding: PaddingValues) {

    val categories = arrayListOf("New Arrivals","Clothes","Bags","Shoese","Electronics","Jewelry")
    Column(modifier = Modifier.padding(top = padding.calculateTopPadding())) {
        Text(text = "Categories", fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
        categories.forEach {
            CategoryCard(it)
        }
    }



}