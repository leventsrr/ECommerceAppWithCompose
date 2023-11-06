package com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.leventsurer.ecommerceappwithcompose.presentation.common.GreetingsTexts
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.HomeEvent
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.HomeViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.NewArrivalProducts
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.RecommendedProduct
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.SearchBoxAndCategoriesButton
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.highlight_categories.HighlightCategories
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.ProductsInCategoryViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.view.composable.ProductCard
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    productInCategoryViewModel: ProductsInCategoryViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    navigateToCategoriesPage: () -> Unit,
    navHostController: NavHostController
) {
    val highlightsProductsState = homeViewModel.newArrivalProductsState.value
    val topCategoriesState = homeViewModel.topCategoriesState.value
    var searchingProductName by rememberSaveable {
        mutableStateOf("")
    }

    var isUserSearchingProduct by remember {
        mutableStateOf(false)
    }
    val focusManager = LocalFocusManager.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 10.dp,
                end = 10.dp,
                top = paddingValues.calculateTopPadding(),
                bottom = paddingValues.calculateBottomPadding()
            )
            .verticalScroll(rememberScrollState())
    ) {
        GreetingsTexts(title = "Welcome,", text = "Our Fashions App")
        Spacer(modifier = Modifier.height(20.dp))
        SearchBoxAndCategoriesButton(
            searchProduct = {
                isUserSearchingProduct = true
                homeViewModel.onEvent(
                    HomeEvent.SearchProductByName(
                        searchingProductName
                    )
                )
            },
            searchingProductName = searchingProductName,
            typeSearchingProductName = {
                searchingProductName = it
            },
            navigateToCategoriesPage = navigateToCategoriesPage,
            cancelSearch = {
                focusManager.clearFocus()
                isUserSearchingProduct = false
                searchingProductName = ""
            }
        )
        Spacer(modifier = Modifier.height(20.dp))


        if (isUserSearchingProduct) {
            if (!homeViewModel.searchProductByNameState.value.products.isNullOrEmpty()) {
                var index = 0
                while (index < homeViewModel.searchProductByNameState.value.products!!.size) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        ProductCard(
                            navHostController = navHostController,
                            productModel = homeViewModel.searchProductByNameState.value.products!![index],
                            productsInProductsInCategoryViewModel = productInCategoryViewModel
                        )
                        if (index + 1 < homeViewModel.searchProductByNameState.value.products!!.size) {
                            ProductCard(
                                navHostController = navHostController,
                                productModel = homeViewModel.searchProductByNameState.value.products!![index + 1],
                                productsInProductsInCategoryViewModel = productInCategoryViewModel
                            )
                        }
                    }
                    index += 2
                }
            } else if (homeViewModel.searchProductByNameState.value.products != null && homeViewModel.searchProductByNameState.value.products!!.isEmpty()) {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "Aradığınız isme ait ürün bulunamadı...")
                }
            }
        } else {
            LaunchedEffect(Unit) {
                homeViewModel.onEvent(HomeEvent.GetHomeScreenData)
            }
            if (highlightsProductsState.isLoading) {
                CircularProgressIndicator()
            } else if (!highlightsProductsState.newArrivalProducts.isNullOrEmpty()) {
                RecommendedProduct(highlightsProductsState.newArrivalProducts[3])
            }

            Spacer(modifier = Modifier.height(20.dp))
            if (topCategoriesState.isLoading) {
                LinearProgressIndicator()
            } else if (!topCategoriesState.topCategories.isNullOrEmpty()) {
                HighlightCategories(
                    highlightsCategories = topCategoriesState.topCategories,
                    navHostController = navHostController
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (highlightsProductsState.isLoading) {
                CircularProgressIndicator()
            } else if (!highlightsProductsState.newArrivalProducts.isNullOrEmpty()) {
                NewArrivalProducts(
                    products = highlightsProductsState.newArrivalProducts,
                    navHostController = navHostController
                )
            }
        }


    }
}

