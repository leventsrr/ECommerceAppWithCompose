package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.view.composable

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.ProductsInCategoryViewModel
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@Composable
fun ProductCard(
    isInFavorites: Boolean,
    navHostController: NavHostController,
    productModel: GetProductResponse,
    addProductToFavorite: (FavoriteProductModel) -> Unit,
    removeProductFromFavorite: (FavoriteProductModel) -> Unit,
    productsInProductsInCategoryViewModel: ProductsInCategoryViewModel
) {
    var isProductFavorite by remember {
        mutableStateOf(isInFavorites)
    }
    val state = productsInProductsInCategoryViewModel.addProductToFavoriteState.value
    if (state.result != null && state.result) {
        Toast.makeText(LocalContext.current, "Favorilere Eklendi", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .width(170.dp)
            .clickable { navHostController.navigate("${Screens.ProductDetailScreen.route}/${productModel.id}") },
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)


        ) {
            AsyncImage(
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(productModel.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )
            OutlinedIconButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(20.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.Black),
                onClick = {
                    val model = FavoriteProductModel(
                        productImageUrl = productModel.image,
                        productTitle = productModel.title,
                        productDescription = productModel.description,
                        productPrice = productModel.price,
                        productCategory = productModel.category,
                        productRating = productModel.rating,
                        productId = productModel.id
                    )
                    if (isProductFavorite) {
                        removeProductFromFavorite(
                            model
                        )
                    } else {
                        addProductToFavorite(
                            model
                        )
                    }

                    isProductFavorite = !isProductFavorite
                }) {
                if (isProductFavorite) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(15.dp)
                    )

                } else {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(15.dp)
                    )
                }

            }
        }

        Text(
            text = productModel.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)

        )
        Text(
            text = "$${productModel.price}",
            maxLines = 1,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)

        )
    }

}