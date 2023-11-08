package com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

@Composable
fun NewArrivalProducts(products: ArrayList<GetProductResponse>, navHostController: NavHostController) {
    Column(modifier = Modifier.padding(horizontal = 5.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(id = R.string.new_arrivals), fontWeight = FontWeight.Bold, fontSize = 20.sp)
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
                    navHostController = navHostController,
                )
                HomePageProductCard(
                    productModel = products[productIndex + 1],
                    navHostController = navHostController,
                )
            }
            productIndex += 2
        }
    }
}