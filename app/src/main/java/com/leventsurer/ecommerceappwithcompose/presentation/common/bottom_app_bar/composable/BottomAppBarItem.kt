package com.leventsurer.ecommerceappwithcompose.presentation.common.bottom_app_bar.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BottomAppBarItem(itemIndex:Int,chosenBottomBarIndex:Int,onClick:(Int)->Unit,itemIcon:ImageVector,itemTitle:String) {


    if (chosenBottomBarIndex == itemIndex) {
        Row(
            Modifier
                .border(0.dp, Color.Transparent, CircleShape)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(Color.LightGray.copy(0.5f)),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilledIconButton(
                modifier = Modifier.size(30.dp),
                colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color.Black),
                onClick = {
                   onClick(0)
                }) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = itemIcon,
                    contentDescription = "",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                text = itemTitle,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    } else {
        IconButton(

            onClick = {
                onClick(itemIndex)
            }) {
            Icon(
                imageVector = itemIcon,
                contentDescription = "",
                tint = Color.LightGray
            )
        }
    }
}