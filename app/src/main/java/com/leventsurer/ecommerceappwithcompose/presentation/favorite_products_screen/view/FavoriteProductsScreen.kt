package com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen.FavoriteEvent
import com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen.FavoriteViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen.view.composable.FavoriteProductCard

@Composable
fun FavoriteProductsScreen(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    favoriteProductsViewModel: FavoriteViewModel = hiltViewModel()
) {
    val favoriteViewModelState = favoriteProductsViewModel.getFavoriteProducts.value
    LaunchedEffect(Unit) {
        favoriteProductsViewModel.onEvent(FavoriteEvent.GetFavoriteProducts)
    }
    if (favoriteViewModelState.isLoading) {
        CircularProgressIndicator(color = Color.Black)
    } else if (!favoriteViewModelState.favoriteProducts.isNullOrEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            favoriteProductsViewModel.getFavoriteProducts.value.favoriteProducts?.let { it ->
                items(it.size) {
                    FavoriteProductCard(
                        favoriteProduct = favoriteViewModelState.favoriteProducts[it],
                        navHostController = navHostController,
                        removeProductFromFavorite = { favoriteProduct->
                            favoriteProductsViewModel.onEvent(
                                FavoriteEvent.DeleteFavoriteProduct(
                                    favoriteProduct
                                )
                            )
                            favoriteProductsViewModel.onEvent(FavoriteEvent.GetFavoriteProducts)
                        },
                    )
                }
            }
        }
    }else if(favoriteViewModelState.favoriteProducts?.isEmpty() == true){
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.favorite_screen_animation))
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
            LottieAnimation(
                modifier = Modifier.fillMaxWidth(),
                composition = composition,
                iterations = LottieConstants.IterateForever,
            )
            Text(text = "You don't have any favorite product", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center, color = Color.LightGray)
        }
    }
}