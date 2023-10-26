package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductDescription
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductQuantity
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductSize
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductTitleAndStar
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable.ProductTotalPriceAndCartButton

@Composable
fun ProductDetailScreen(padding:PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = padding.calculateBottomPadding())
    ) {

        Image(contentScale = ContentScale.FillBounds,painter = painterResource(id = R.drawable.model2), contentDescription = "",
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .align(Alignment.TopCenter)
                .fillMaxSize()
        )


        Box(modifier = Modifier
            .fillMaxHeight(0.55f)
            .align(Alignment.BottomCenter)
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
            .background(Color.White)) {
            Column(modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.End) {
                FilledIconButton(
                    colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color.White, contentColor = Color.Black),
                    modifier = Modifier.size(30.dp),
                    onClick = { /*TODO*/ },
                ) {
                    Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "")
                }
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    ProductTitleAndStar()
                    ProductQuantity()
                }
                Spacer(modifier = Modifier.height(5.dp))
                ProductSize()
                Spacer(modifier = Modifier.height(5.dp))
                ProductDescription()
                Spacer(modifier = Modifier.height(5.dp))
                ProductTotalPriceAndCartButton()


            }
        }

    }
}