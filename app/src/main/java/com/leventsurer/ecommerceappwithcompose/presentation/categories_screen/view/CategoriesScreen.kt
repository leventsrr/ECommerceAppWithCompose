package com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Checkroom
import androidx.compose.material.icons.outlined.ElectricalServices
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.ShoppingCartCheckout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.composable.CategoryCard

@Composable
fun CategoriesScreen(padding: PaddingValues) {

    val categories = arrayListOf("New Arrivals","Clothes","Bags","Shoese","Electronics","Jewelry")
    val categoryIcon = arrayListOf(Icons.Outlined.ShoppingCartCheckout,Icons.Outlined.Checkroom,Icons.Outlined.ShoppingBag,Icons.Outlined.ElectricalServices)
    Column(modifier = Modifier.padding(top = padding.calculateTopPadding(), start = 5.dp, end = 5.dp)) {
        Text(text = "Categories", fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
        categories.forEach {
            CategoryCard(categoryIcon = categoryIcon[3], categoryName = it, categoryProductQuantity = 12)
        }
    }



}