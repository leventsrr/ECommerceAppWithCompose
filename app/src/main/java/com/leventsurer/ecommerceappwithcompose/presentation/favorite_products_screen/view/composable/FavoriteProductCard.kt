package com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen.view.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen.FavoriteEvent
import com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen.FavoriteViewModel
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@Composable
fun FavoriteProductCard(
    removeProductFromFavorite:(FavoriteProductModel)->Unit,
    favoriteProduct: FavoriteProductModel,
    navHostController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .padding(bottom = 10.dp)
            .clickable {
                      navHostController.navigate("${Screens.ProductDetailScreen.route}/${favoriteProduct.productId}")
            },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(15.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(favoriteProduct.productImageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(
                    text = favoriteProduct.productTitle,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 25.sp
                )
                Text(
                    text = favoriteProduct.productDescription,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = "$${favoriteProduct.productPrice}")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "${favoriteProduct.productRating.rate}/(${favoriteProduct.productRating.count})")
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            removeProductFromFavorite(favoriteProduct)
                        })
                }
            }
        }
    }
}