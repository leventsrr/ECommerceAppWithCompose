package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.mutableFloatStateOf
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
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
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
    //the maximum height that the Column in which the product detail is located can take
    var productDetailColumnLastHeight by remember {
        mutableFloatStateOf(0.55f)
    }
    var offset by remember { mutableFloatStateOf(0f) }
    var currentProductDetailHeight by remember {
        mutableFloatStateOf(
            (-offset
                .toString()
                .take(3)
                .toFloat() / 100) + 0.55f
        )
    }
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val localDensity = LocalDensity.current

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
                    .fillMaxHeight(
                        if (
                            (-offset
                                .toString()
                                .take(3)
                                .toFloat() / 100) + 0.55f >= productDetailColumnLastHeight
                        ) {
                            Log.e("kontrol","image if")
                            1.0f - productDetailColumnLastHeight
                        } else {
                            Log.e("kontrol","image else")
                            if ((0.5f - (-offset
                                    .toString()
                                    .take(3)
                                    .toFloat() / 100) < 0.5f)
                            ) {
                                Log.e("kontrol","image else -> iff")
                                0.5f - (-offset
                                    .toString()
                                    .take(3)
                                    .toFloat() / 100)
                            } else {
                                Log.e("kontrol","image else else")
                                0.5f
                            }
                        }


                    )
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
                    .fillMaxHeight(
                        if (
                            currentProductDetailHeight >= productDetailColumnLastHeight
                        ) {
                            productDetailColumnLastHeight

                        } else {
                            if (
                                currentProductDetailHeight > 0.55f
                            ) {
                                currentProductDetailHeight + 0.55f
                            } else {
                                0.55f
                            }
                        }


                    )
                    .align(Alignment.BottomCenter)
                    .border(1.dp, Color.LightGray, RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                    .background(Color.White)
                    .scrollable(
                        orientation = Orientation.Vertical,
                        state = rememberScrollableState { delta ->
                            offset += delta
                            currentProductDetailHeight = calculateCurrentProductDetailHeight(offset)
                            delta
                        }
                    )

            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                        .onSizeChanged { size ->
                            if (size.height > productDetailColumnLastHeight) {
                                productDetailColumnLastHeight =
                                    with(localDensity) { size.height.toDp() } / screenHeight
                                Log.e("kontrol", " if en büyük:${productDetailColumnLastHeight}")
                            } else {
                                Log.e("kontrol", " else en büyük:${productDetailColumnLastHeight}")
                            }
                        }
                        .wrapContentHeight(),
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

private fun calculateCurrentProductDetailHeight(offset: Float): Float {
    return (-offset.toString().take(3).toFloat() / 100) + 0.55f
}