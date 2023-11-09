package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.leventsurer.ecommerceappwithcompose.R
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
    var favoriteProductsId: List<Int> by remember {
        mutableStateOf(emptyList())
    }
    LaunchedEffect(Unit) {
        productsInProductsInCategoryViewModel.onEvent(
            ProductsInCategoryEvent.GetProductInProductsInCategory(
                categoryName
            )
        )
        productsInProductsInCategoryViewModel.onEvent(
            ProductsInCategoryEvent.GetFavoriteProducts
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
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.category_product_loading_animation))
            Column(modifier = Modifier.fillMaxWidth().wrapContentHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                LottieAnimation(
                    modifier = Modifier.fillMaxWidth(),
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                )
            }
        } else if (!productsInCategoryViewModelState.productsInCategory.isNullOrEmpty()
            && productsInProductsInCategoryViewModel.getFavoriteProducts.value.favoriteProducts != null
        ) {
            val products = productsInCategoryViewModelState.productsInCategory
            favoriteProductsId =
                productsInProductsInCategoryViewModel.getFavoriteProducts.value.favoriteProducts!!.map { product ->
                    product.productId
                }
            var productIndex = 0
            while (productIndex < products.size) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProductCard(
                        isInFavorites = productsInCategoryViewModelState.productsInCategory[productIndex].id in favoriteProductsId,
                        productModel = productsInCategoryViewModelState.productsInCategory[productIndex],
                        navHostController = navHostController,
                        productsInProductsInCategoryViewModel = productsInProductsInCategoryViewModel,
                        addProductToFavorite = { favoriteProduct ->
                            productsInProductsInCategoryViewModel.onEvent(
                                ProductsInCategoryEvent.AddProductToCart(
                                    favoriteProduct
                                )
                            )
                        },
                        removeProductFromFavorite = { favoriteProductModel ->
                            productsInProductsInCategoryViewModel.onEvent(
                                ProductsInCategoryEvent.RemoveProductFromFavorite(
                                    favoriteProductModel
                                )
                            )
                        }
                    )
                    ProductCard(
                        isInFavorites = productsInCategoryViewModelState.productsInCategory[productIndex + 1].id in favoriteProductsId,
                        productModel = productsInCategoryViewModelState.productsInCategory[productIndex + 1],
                        navHostController = navHostController,
                        productsInProductsInCategoryViewModel = productsInProductsInCategoryViewModel,
                        addProductToFavorite = { favoriteProduct ->
                            productsInProductsInCategoryViewModel.onEvent(
                                ProductsInCategoryEvent.AddProductToCart(
                                    favoriteProduct
                                )
                            )
                        },
                        removeProductFromFavorite = { favoriteProductModel ->
                            productsInProductsInCategoryViewModel.onEvent(
                                ProductsInCategoryEvent.RemoveProductFromFavorite(
                                    favoriteProductModel
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

