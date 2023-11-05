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
fun GeneralAppSettings(generalAppSectionRowItemIcons:ArrayList<ImageVector>, generalAppSectionRowItemTitles:ArrayList<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                2.dp, Color.LightGray,
                RoundedCornerShape(10.dp)
            )
    ) {
        Column {
            for (i in 0 until generalAppSectionRowItemIcons.size) {
                UserSectionRow(
                    icon = generalAppSectionRowItemIcons[i],
                    title = generalAppSectionRowItemTitles[i],
                    topPadding = if (i == 0) 25.dp else 0.dp,
                    bottomPadding = if (i == generalAppSectionRowItemIcons.size - 1) 25.dp else 0.dp
                )
            }
        }

    }
}
