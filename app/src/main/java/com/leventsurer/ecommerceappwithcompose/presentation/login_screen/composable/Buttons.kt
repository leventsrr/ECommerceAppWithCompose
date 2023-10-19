package com.leventsurer.ecommerceappwithcompose.presentation.login_screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.common.CustomElevatedButton
import com.leventsurer.ecommerceappwithcompose.ui.theme.FacebookThemeColor

@Composable
fun Buttons(
    navigateToHomePage:()->Unit

) {

    CustomElevatedButton("Login",{navigateToHomePage()})
    Spacer(modifier = Modifier.height(5.dp))
    Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        Divider(modifier = Modifier.weight(1f))
        Text(text = "or", modifier = Modifier.padding(horizontal = 3.dp))
        Divider(modifier = Modifier.weight(1f))
    }
    Spacer(modifier = Modifier.height(5.dp))

    CustomElevatedButton("Continue with Facebook",{},FacebookThemeColor, Color.White,R.drawable.facebook_icon)
    Spacer(modifier = Modifier.height(5.dp))
    CustomElevatedButton("Continue with Google",{},Color.White, Color.Gray,R.drawable.google_icon)

    Spacer(modifier = Modifier.height(5.dp))

    CustomElevatedButton(buttonText = "Continue with Apple", onClick = {}, backgroundColor = Color.White, textColor = Color.Gray, logo = R.drawable.apple_icon)
}
