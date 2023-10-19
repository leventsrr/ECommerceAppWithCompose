package com.leventsurer.ecommerceappwithcompose.presentation.splash_screen.view


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leventsurer.ecommerceappwithcompose.R

@Composable
fun SplashScreen(
    scaffoldPadding:PaddingValues,
    onSignUpNavigateClick:()->Unit,
    onLoginNavigateClick:()->Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.model2),
                contentScale = ContentScale.FillBounds
            ).padding(scaffoldPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
            Text(
                text = "Fashions",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )
            Text(text = "My Life My Style", color = Color.White, fontWeight = FontWeight.Bold)
        }

        Column(
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                onClick = onLoginNavigateClick
            ) {
                Text(text = "Login", color = Color.Black, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(8.dp))
            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                border = BorderStroke(
                    2.dp,
                    Color.White
                ),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                onClick = onSignUpNavigateClick
            ) {
                Text(text = "Sign Up", fontWeight = FontWeight.Bold)
            }
        }
    }


}