package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.ProductsInCategoryEvent
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.ProductsInCategoryViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.view.composable.ProductCard

@Composable
fun ProductsInCategoryScreen(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    categoryName: String,
    productsInProductsInCategoryViewModel: ProductsInCategoryViewModel = hiltViewModel()
) {
    val productsInCategoryViewModelState =
        productsInProductsInCategoryViewModel.productsInCategoryState.value
    LaunchedEffect(Unit) {
        productsInProductsInCategoryViewModel.onEvent(
            ProductsInCategoryEvent.GetProductInProductsInCategory(
                categoryName
            )
        )
    }
    Column(
        Modifier
            .padding(
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            )
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = categoryName,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(start = 10.dp)
        )
        if (productsInCategoryViewModelState.isLoading) {
            CircularProgressIndicator()
        } else if (!productsInCategoryViewModelState.productsInCategory.isNullOrEmpty()) {
            val products = productsInCategoryViewModelState.productsInCategory
            var productIndex = 0
            while (productIndex < products.size) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProductCard(
                        productModel = products[productIndex],
                        navHostController = navHostController,
                        productsInProductsInCategoryViewModel = productsInProductsInCategoryViewModel
                    )
                    ProductCard(
                        productModel = products[productIndex + 1],
                        navHostController = navHostController,
                        productsInProductsInCategoryViewModel = productsInProductsInCategoryViewModel
                    )
                }
                productIndex += 2
            }
        }
    }
}

