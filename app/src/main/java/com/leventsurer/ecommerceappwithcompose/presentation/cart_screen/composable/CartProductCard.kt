package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel
import kotlin.math.roundToInt

@Composable
fun CartProductCard(
    productInCartModel: ProductInCartModel
) {
    var moved by remember { mutableStateOf(false) }
    val pxToMove = with(LocalDensity.current) {
        -50.dp.toPx().roundToInt()
    }
    val offset by animateIntOffsetAsState(
        targetValue = if (moved) {
            IntOffset(pxToMove, 0)
        } else {
            IntOffset.Zero
        },
        label = "offset"
    )

    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 5.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .offset { offset }
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    moved = !moved
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .padding(5.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(productInCartModel.productImageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(5f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = productInCartModel.productTitle,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = productInCartModel.productId.toString(),
                        fontWeight = FontWeight.Light
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$${(productInCartModel.productPrice.toDouble() * productInCartModel.productQuantity)}",
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "x${productInCartModel.productQuantity}",
                        modifier = Modifier
                            .padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 10.dp)
                    )
                }
            }
        }
        Divider(color = Color.LightGray, thickness = 0.5.dp)
    }
}