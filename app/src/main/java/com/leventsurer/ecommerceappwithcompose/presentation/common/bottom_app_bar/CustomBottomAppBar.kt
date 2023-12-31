package com.leventsurer.ecommerceappwithcompose.presentation.common.bottom_app_bar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.leventsurer.ecommerceappwithcompose.R
import com.leventsurer.ecommerceappwithcompose.presentation.common.bottom_app_bar.composable.BottomAppBarItem
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@SuppressLint("SuspiciousIndentation")
@Composable
fun CustomBottomAppBar(navHostController: NavHostController?) {
    var chosenBottomBarIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    val navBackStackEntry by navHostController!!.currentBackStackEntryAsState()
    when (navBackStackEntry?.destination?.route) {
        Screens.HomeScreen.route -> {
            chosenBottomBarIndex = 0
        }

        Screens.CartScreen.route -> {
            chosenBottomBarIndex = 1
        }

        Screens.FavoriteProductsScreen.route -> {
            chosenBottomBarIndex = 2
        }

        Screens.ProfileScreen.route -> {
            chosenBottomBarIndex = 3
        }
    }

    if (!(navBackStackEntry?.destination?.route == Screens.OnBoardingScreen.route
                || navBackStackEntry?.destination?.route == Screens.SplashScreen.route
                || navBackStackEntry?.destination?.route == Screens.LoginScreen.route
                || navBackStackEntry?.destination?.route == Screens.RegisterScreen.route
                || navBackStackEntry?.destination?.route?.contains(Screens.ProductDetailScreen.route) == true
                )
    ) {
        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                .height(100.dp),
            containerColor = Color.White,
            content = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BottomAppBarItem(
                        itemIndex = 0,
                        chosenBottomBarIndex = chosenBottomBarIndex,
                        onClick = {
                            chosenBottomBarIndex = it
                            navHostController?.navigate(Screens.HomeScreen.route)
                        },
                        itemIcon = Icons.Default.Home,
                        itemTitle = stringResource(id = R.string.home)
                    )
                    BottomAppBarItem(
                        itemIndex = 1,
                        chosenBottomBarIndex = chosenBottomBarIndex,
                        onClick = {
                            chosenBottomBarIndex = it
                            navHostController?.navigate(Screens.CartScreen.route)
                        },
                        itemIcon = Icons.Default.ShoppingCart,
                        itemTitle = stringResource(id = R.string.cart)
                    )
                    BottomAppBarItem(
                        itemIndex = 2,
                        chosenBottomBarIndex = chosenBottomBarIndex,
                        onClick = {
                            chosenBottomBarIndex = it
                            navHostController?.navigate(Screens.FavoriteProductsScreen.route)
                        },
                        itemIcon = Icons.Default.Favorite,
                        itemTitle = stringResource(id = R.string.favorite)
                    )
                    BottomAppBarItem(
                        itemIndex = 3,
                        chosenBottomBarIndex = chosenBottomBarIndex,
                        onClick = {
                            chosenBottomBarIndex = it
                            navHostController?.navigate(Screens.ProfileScreen.route)
                        },
                        itemIcon = Icons.Default.Person,
                        itemTitle = stringResource(id = R.string.profile)
                    )
                }
            }
        )
    }
}