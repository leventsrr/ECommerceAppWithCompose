package com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.highlight_categories

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@Composable
fun HighlightCategoryCard(categoryName: String, navHostController: NavHostController) {
    Row(modifier = Modifier.clickable {
        navHostController.navigate("${Screens.ProductsInCategoryScreen.route}/$categoryName")
    }) {
        Box(
            modifier = Modifier
                .width(130.dp)
                .height(70.dp)
                .border(
                    1.dp, Color.LightGray,
                    RoundedCornerShape(5.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = categoryName,
                modifier = Modifier.padding(5.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
    }
}