package com.leventsurer.ecommerceappwithcompose.presentation.profile_screen.view.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun UserSection(rowItemIcons:ArrayList<ImageVector>, rowItemTitle: Array<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                2.dp, Color.LightGray,
                RoundedCornerShape(10.dp)
            )
    ) {
        Column {
            for (i in rowItemTitle.indices) {
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