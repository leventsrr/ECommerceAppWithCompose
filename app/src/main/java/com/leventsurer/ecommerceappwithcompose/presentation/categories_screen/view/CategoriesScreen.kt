package com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Checkroom
import androidx.compose.material.icons.outlined.ElectricalServices
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.ShoppingCartCheckout
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.domain.model.CategoryProductQuantityModel
import com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.CategoriesEvent
import com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.CategoriesViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.view.composable.CategoryCard

@Composable
fun CategoriesScreen(
    padding: PaddingValues,
    categoriesViewModel: CategoriesViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val categoriesState = categoriesViewModel.categoriesState.value
    val productQuantityState = categoriesViewModel.productsInCategoryState.value
    LaunchedEffect(Unit) {
        categoriesViewModel.onEvent(CategoriesEvent.GetAllCategories)
    }

    Column(
        modifier = Modifier.padding(
            top = padding.calculateTopPadding(),
            start = 5.dp,
            end = 5.dp
        )
    ) {
        Text(
            text = stringResource(id = R.string.categories),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp
        )
        if (productQuantityState.isLoading) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.categories_loading_animation))
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                LottieAnimation(
                    modifier = Modifier.fillMaxWidth(),
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                )
            }
        } else if (!productQuantityState.productsAndQuantity.isNullOrEmpty()) {
            productQuantityState.productsAndQuantity.forEach {
                CategoryCard(
                    categoryName = it.categoryName,
                    categoryProductQuantity = it.categoryQuantity,
                    navHostController = navHostController
                )
            }
        } else if (!categoriesState.error.isNullOrEmpty() || !productQuantityState.error.isNullOrEmpty()) {
            val errorText = categoriesState.error ?: productQuantityState.error
            Toast.makeText(LocalContext.current, "$errorText", Toast.LENGTH_SHORT).show()
        }
    }
}