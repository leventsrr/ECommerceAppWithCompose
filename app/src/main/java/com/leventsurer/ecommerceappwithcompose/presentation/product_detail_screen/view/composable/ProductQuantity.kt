package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R

@Composable
fun ProductQuantity(productQuantity:Int,increaseProductQuantity:(Int)-> Unit,decreaseProductQuantity:(Int)->Unit) {
    Column(horizontalAlignment = Alignment.End) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.LightGray.copy(0.6f))
                .width(100.dp)
        ) {
            Icon(painter = painterResource(id = R.drawable.baseline_remove_24), contentDescription ="add" , modifier = Modifier
                .align(
                    Alignment.CenterStart
                )
                .padding(start = 5.dp, top = 5.dp, bottom = 5.dp)
                .clickable { decreaseProductQuantity(productQuantity-1)})
            Text(text = productQuantity.toString(), modifier = Modifier
                .align(
                    Alignment.Center
                )
                .padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 10.dp)
                )
            Icon(imageVector = Icons.Default.Add, contentDescription ="add", modifier = Modifier
                .align(
                    Alignment.CenterEnd
                )
                .padding(end = 5.dp, top = 5.dp, bottom = 5.dp)
                .clickable { increaseProductQuantity(productQuantity+1) })
        }
    }
}