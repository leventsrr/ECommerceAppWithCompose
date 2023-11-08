package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.ProductDetailEvent
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.ProductDetailViewModel
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductDescription
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductQuantity
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductSize
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductTitleAndStar
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductTotalPriceAndCartButton

@Composable
fun ProductDetailScreen(
    padding: PaddingValues,
    productId: String?,
    productDetailViewModel: ProductDetailViewModel = hiltViewModel()
) {
    var isInFavorite by remember {
        mutableStateOf(false)
    }
    val productDetailViewModelState = productDetailViewModel.getAProductByIdState.value
    var productQuantity by rememberSaveable {
        mutableIntStateOf(1)
    }
    LaunchedEffect(Unit) {
        productDetailViewModel.onEvent(ProductDetailEvent.GetProductDetailById(productId ?: "-1"))
    }

    if (productDetailViewModelState.isLoading) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(color = Color.Black)
        }
    } else if (productDetailViewModelState.productDetail != null && productDetailViewModel.getFavoriteProductsState.value.result != null) {
        val productDetail: GetProductResponse = productDetailViewModelState.productDetail
        val favoriteProductsId =
            productDetailViewModel.getFavoriteProductsState.value.result!!.map { it.productId }
        isInFavorite = productDetail.id in favoriteProductsId
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = padding.calculateBottomPadding())

        ) {
            AsyncImage(
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .align(Alignment.TopCenter)
                    .fillMaxSize()
                    .background(Color.White),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(productDetailViewModelState.productDetail.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.55f)
                    .align(Alignment.BottomCenter)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                    .background(Color.White)

            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                        .fillMaxHeight()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End
                ) {
                    FilledIconButton(
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier.size(30.dp),
                        onClick = {
                            val model = FavoriteProductModel(
                                productImageUrl = productDetail.image,
                                productTitle = productDetail.title,
                                productDescription = productDetail.description,
                                productPrice = productDetail.price,
                                productCategory = productDetail.category,
                                productRating = productDetail.rating,
                                productId = productDetail.id
                            )
                            if (isInFavorite) {
                                productDetailViewModel.onEvent(
                                    ProductDetailEvent.RemoveProductToFavorites(
                                        model
                                    )
                                )
                            } else {
                                productDetailViewModel.onEvent(
                                    ProductDetailEvent.AddProductToFavorites(
                                        model
                                    )
                                )
                            }
                            isInFavorite = !isInFavorite
                        },
                    ) {
                        if (isInFavorite) {
                            Icon(
                                imageVector = Icons.Outlined.Favorite,
                                contentDescription = "",
                                tint = Color.Black,
                                modifier = Modifier.size(15.dp)
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Filled.FavoriteBorder,
                                contentDescription = "",
                                tint = Color.Black,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.weight(3f)) {
                            ProductTitleAndStar(
                                productName = productDetail.title,
                                productId = productDetail.id.toString(),
                                productRate = productDetail.rating,
                            )
                        }
                        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                            ProductQuantity(
                                productQuantity,
                                increaseProductQuantity = {
                                    productQuantity = it
                                },
                                decreaseProductQuantity = {
                                    productQuantity = it
                                },
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    if (productDetail.category == "men's clothing" || productDetail.category == "women's clothing") {
                        ProductSize()
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    ProductDescription(productDetail.description)
                    Spacer(modifier = Modifier.height(5.dp))

                    ProductTotalPriceAndCartButton(
                        totalPrice = (productQuantity.toDouble() * productDetail.price.toDouble()),
                        addProductToCart = {
                            productDetailViewModel.onEvent(ProductDetailEvent.AddProductToCart(it))
                        },
                        productModel = productDetailViewModelState.productDetail,
                        productQuantity = productQuantity
                    )
                }
            }

        }
    }
}