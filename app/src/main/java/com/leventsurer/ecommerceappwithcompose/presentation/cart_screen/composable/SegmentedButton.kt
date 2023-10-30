package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SegmentedButton(selectedSegment:Int,onSegmentSelect:(Int)->Unit) {
    Row(
        modifier = Modifier
            .width(200.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                Color.LightGray,
                RoundedCornerShape(20.dp)
            )
    ) {
        Text(
            text = "Current",
            modifier = Modifier
                .weight(1f)
                .background(if (selectedSegment == 0) Color.LightGray else Color.White)
                .clickable { onSegmentSelect(0) },
            textAlign = TextAlign.Center,

            )
        Text(
            text = "Past",
            modifier = Modifier
                .weight(1f)
                .background(if (selectedSegment == 0) Color.White else Color.LightGray)
                .clickable { onSegmentSelect(1) },
            textAlign = TextAlign.Center
        )
    }
}