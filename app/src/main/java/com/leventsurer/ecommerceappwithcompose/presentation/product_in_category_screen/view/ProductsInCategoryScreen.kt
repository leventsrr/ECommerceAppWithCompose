package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Product
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.HomePageProductCard
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
                        addProductToCart = {
                            productsInProductsInCategoryViewModel.onEvent(
                                ProductsInCategoryEvent.AddProductToCart(
                                    ProductModel(
                                        productImageUrl = products[productIndex].image,
                                        productTitle = products[productIndex].title,
                                        productDescription = products[productIndex].description,
                                        productPrice = products[productIndex].price,
                                        productCategory = products[productIndex].category,
                                        productRating = products[productIndex].rating,
                                        productId = products[productIndex].id
                                    )
                                )
                            )
                        }
                    )
                    ProductCard(
                        productModel = products[productIndex + 1],
                        navHostController = navHostController,
                        addProductToCart = {
                            productsInProductsInCategoryViewModel.onEvent(
                                ProductsInCategoryEvent.AddProductToCart(
                                    ProductModel(
                                        productImageUrl = products[productIndex].image,
                                        productTitle = products[productIndex].title,
                                        productDescription = products[productIndex].description,
                                        productPrice = products[productIndex].price,
                                        productCategory = products[productIndex].category,
                                        productRating = products[productIndex].rating,
                                        productId = products[productIndex].id
                                    )
                                )
                            )
                        }
                    )
                }
                productIndex += 2
            }
        }
    }
}

