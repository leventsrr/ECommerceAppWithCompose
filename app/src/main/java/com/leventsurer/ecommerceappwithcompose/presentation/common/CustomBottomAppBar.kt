package com.leventsurer.ecommerceappwithcompose.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@Composable
fun CustomBottomAppBar(navBackStackEntry: NavBackStackEntry?) {
    var chosenBottomBarIndex by remember {
        mutableIntStateOf(0)
    }
    //val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    if (navBackStackEntry?.destination?.route == Screens.OnBoardingScreen.route
        || navBackStackEntry?.destination?.route == Screens.SplashScreen.route
        || navBackStackEntry?.destination?.route == Screens.LoginScreen.route
        || navBackStackEntry?.destination?.route == Screens.RegisterScreen.route
    ){

    }else{
        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                .height(100.dp),
            containerColor = Color.White,
            content = {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {
                            chosenBottomBarIndex = 0
                        }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "",
                            tint = if (chosenBottomBarIndex == 0) Color.Black else Color.Black.copy(
                                0.5f
                            )
                        )
                    }
                    IconButton(
                        onClick = { chosenBottomBarIndex = 1 }) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "",
                            tint = if (chosenBottomBarIndex == 1) Color.Black else Color.Black.copy(
                                0.5f
                            )
                        )
                    }
                    IconButton(
                        onClick = { chosenBottomBarIndex = 2 }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "",
                            tint = if (chosenBottomBarIndex == 2) Color.Black else Color.Black.copy(
                                0.5f
                            )
                        )
                    }
                    IconButton(
                        onClick = { chosenBottomBarIndex = 3 }) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "",
                            tint = if (chosenBottomBarIndex == 3) Color.Black else Color.Black.copy(
                                0.5f
                            )
                        )
                    }
                }
            }
        )
    }

}