package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Rating
import com.leventsurer.ecommerceappwithcompose.ui.theme.Orange

@Composable
fun ProductTitleAndStar(productName:String,productId:String,productRate:Rating) {
    Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
        Text(text = productName, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = productId,
            fontSize = 15.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row() {
            for(i in 0..productRate.rate.toInt()){
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "",
                    tint = Orange,
                    modifier = Modifier.size(20.dp)
                )
            }
            for(i in 0 until (5-productRate.rate).toInt()){
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "",
                    tint = Color.Red,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "(${productRate.count})")
        }
    }
}