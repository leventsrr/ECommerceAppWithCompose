package com.leventsurer.ecommerceappwithcompose.presentation.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GreetingsTexts(title:String,text:String) {
    Column() {
        Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), fontSize = 23.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = text, fontSize = 16.sp)
    }
}
