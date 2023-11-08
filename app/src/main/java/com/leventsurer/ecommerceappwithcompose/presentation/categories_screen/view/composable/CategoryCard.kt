package com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.view.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@Composable
fun CategoryCard(
    categoryName: String,
    categoryProductQuantity: Int,
    navHostController: NavHostController
) {
    Card(
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable {
                navHostController.navigate("${Screens.ProductsInCategoryScreen.route}/$categoryName")
            }) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 10.dp)
        ) {
            Text(text = categoryName, color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = "$categoryProductQuantity ${stringResource(id = R.string.product)}", color = Color.White)
        }
    }
}