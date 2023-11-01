package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.view.composable

import android.hardware.lights.Light
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Product
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@Composable
fun ProductCard(
    navHostController: NavHostController,
    productModel: GetProductResponse,
    addProductToCart:(Product)->Unit
) {

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
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "",
                modifier = Modifier.align(
                    Alignment.BottomEnd
                ).clickable {

                }
            )
        }


        Text(
            text = productModel.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
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