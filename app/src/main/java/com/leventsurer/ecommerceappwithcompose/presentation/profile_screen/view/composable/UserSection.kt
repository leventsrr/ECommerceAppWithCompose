package com.leventsurer.ecommerceappwithcompose.presentation.profile_screen.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun UserSection(rowItemIcons:ArrayList<ImageVector>,rowItemTitle:ArrayList<String>) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                2.dp, Color.LightGray,
                RoundedCornerShape(10.dp)
            )
    ) {
        Column {
            for (i in 0 until rowItemTitle.size) {
                UserSectionRow(
                    icon = rowItemIcons[i],
                    title = rowItemTitle[i],
                    topPadding = if (i == 0) 25.dp else 0.dp,
                    bottomPadding = if (i == rowItemIcons.size - 1) 25.dp else 0.dp
                )
            }
        }

    }
}