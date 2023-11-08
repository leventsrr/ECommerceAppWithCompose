package com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.highlight_categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.leventsurer.ecommerceappwithcompose.R

@Composable
fun HighlightCategories(
    highlightsCategories: ArrayList<String>,
    navHostController: NavHostController
) {
    Column(modifier = Modifier.padding(horizontal = 5.dp)) {
        Text(
            text = stringResource(id = R.string.top_categories),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        LazyRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            itemsIndexed(highlightsCategories) { _, item ->
                HighlightCategoryCard(categoryName = item, navHostController = navHostController)
            }
        }
    }
}