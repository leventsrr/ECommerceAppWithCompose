package com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.common.GreetingsTexts
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.HomeEvent
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.HomeViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.NewArrivalProducts
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.RecommendedProduct
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.SearchBoxAndCategoriesButton
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.composable.highlight_categories.HighlightCategories

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    navigateToCategoriesPage: () -> Unit,
    onProductDetailClick: () -> Unit
) {
    val highlightsProductsState = homeViewModel.newArrivalProductsState.value
    val topCategoriesState = homeViewModel.topCategoriesState.value
    LaunchedEffect(Unit) {
        homeViewModel.onEvent(HomeEvent.GetHomeScreenData)
    }

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
        SearchBoxAndCategoriesButton(navigateToCategoriesPage)
        Spacer(modifier = Modifier.height(20.dp))
        RecommendedProduct()
        Spacer(modifier = Modifier.height(20.dp))
        if (!topCategoriesState.topCategories.isNullOrEmpty()) {
            HighlightCategories(highlightsCategories = topCategoriesState.topCategories)
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (highlightsProductsState.isLoading) {
            CircularProgressIndicator()
        } else if (!highlightsProductsState.newArrivalProducts.isNullOrEmpty()) {
            NewArrivalProducts(
                products = highlightsProductsState.newArrivalProducts,
                onProductDetailClick =  onProductDetailClick )
        }
    }
}

