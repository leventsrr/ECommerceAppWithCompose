package com.leventsurer.ecommerceappwithcompose.presentation.login_screen.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.login_screen.composable.Buttons
import com.leventsurer.ecommerceappwithcompose.presentation.common.GreetingsTexts
import com.leventsurer.ecommerceappwithcompose.presentation.login_screen.composable.Inputs

@Composable
fun LoginScreen(
    padding: PaddingValues,
    navigateToHomePage: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding.calculateTopPadding()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
        Spacer(modifier = Modifier.height(50.dp))

        GreetingsTexts("Welcome!", "Please login or sign up to continue our app")
        Spacer(modifier = Modifier.height(50.dp))
        Inputs()
        Spacer(modifier = Modifier.height(25.dp))
        Buttons(navigateToHomePage = navigateToHomePage)
    }
}



