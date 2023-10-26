package com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R

@Composable
fun HomePageProductCard(
    onProductDetailClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .width(150.dp)
            .clickable { onProductDetailClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {

            Image(
                painter = painterResource(id = R.drawable.model2),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(text = "Product Name")

        }
    }
}