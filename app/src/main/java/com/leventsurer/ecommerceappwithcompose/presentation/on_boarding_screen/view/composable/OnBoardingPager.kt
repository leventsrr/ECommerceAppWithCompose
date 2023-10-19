package com.leventsurer.ecommerceappwithcompose.presentation.on_boarding_screen.view.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnBoardingPager(image:Int,title:String,description:String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter =  painterResource(id = image), contentDescription ="image", modifier = Modifier.padding(top = 10.dp) )
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = title, lineHeight = 30.sp, fontWeight = FontWeight.ExtraBold, fontSize = 22.sp, modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = description, fontWeight = FontWeight.Light, fontSize = 16.sp,modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp))

    }
}