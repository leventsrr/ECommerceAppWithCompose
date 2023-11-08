package com.leventsurer.ecommerceappwithcompose.presentation.common

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DoorFront
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    navHostController: NavHostController,
    onBackClick:()->Unit
    ) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
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
                if (navBackStackEntry?.destination?.route == Screens.HomeScreen.route){
                    FilledIconButton(
                        shape = CircleShape,
                        colors = IconButtonDefaults.filledIconButtonColors(containerColor = Color.Black),
                        modifier = Modifier
                            .size(30.dp),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Filled.DoorFront,
                            contentDescription = "",
                            tint = Color.White,
                        )
                    }
                }else{
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
                }
            },
        )
    }
}