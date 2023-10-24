package com.leventsurer.ecommerceappwithcompose.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    navBackStackEntry: NavBackStackEntry?,
    onBackClick:()->Unit
    ) {
    if (navBackStackEntry?.destination?.route == Screens.OnBoardingScreen.route
        || navBackStackEntry?.destination?.route == Screens.SplashScreen.route
        || navBackStackEntry?.destination?.route == Screens.LoginScreen.route
        || navBackStackEntry?.destination?.route == Screens.RegisterScreen.route
    ) {

    } else {
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent),
            title = { },
            navigationIcon = {

               FilledIconButton(
                   shape = CircleShape,
                   colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color.Black),
                    modifier = Modifier
                        .size(30.dp),
                    onClick = onBackClick
               ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.White,
                    )
                }


            },
            actions = {
                if(navBackStackEntry?.destination?.route == Screens.HomeScreen.route){
                  IconButton(
                        onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    }
                }else{
                    FilledIconButton(
                        shape = CircleShape,
                        colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color.Black),
                        onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }

            }
        )
    }

}