package com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.NewArrivalProductsState

@Composable
fun NewArrivalProducts(products:ArrayList<GetProductResponse>,onProductDetailClick:()->Unit) {
    Column(modifier = Modifier.padding(horizontal = 5.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "New Arrivals", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = "View All", fontWeight = FontWeight.Bold, fontSize = 13.sp)
        }
            var productIndex = 0
            while (productIndex < products.size) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HomePageProductCard(
                        productModel = products[productIndex],
                        onProductDetailClick = onProductDetailClick
                    )
                    HomePageProductCard(
                        productModel = products[productIndex + 1],
                        onProductDetailClick = onProductDetailClick
                    )
                }
                productIndex += 2
            }
        }


}