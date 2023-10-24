package com.leventsurer.ecommerceappwithcompose.presentation.common.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.leventsurer.ecommerceappwithcompose.presentation.common.appbar.composable.BottomAppBarItem
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@Composable
fun CustomBottomAppBar(navBackStackEntry: NavBackStackEntry?) {
    var chosenBottomBarIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    //val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    if (navBackStackEntry?.destination?.route == Screens.OnBoardingScreen.route
        || navBackStackEntry?.destination?.route == Screens.SplashScreen.route
        || navBackStackEntry?.destination?.route == Screens.LoginScreen.route
        || navBackStackEntry?.destination?.route == Screens.RegisterScreen.route
    ) {

    } else {
        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                .height(120.dp),
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
                        onClick = { chosenBottomBarIndex = it },
                        itemIcon = Icons.Default.Home,
                        itemTitle = "Home"
                    )
                    BottomAppBarItem(
                        itemIndex = 1,
                        chosenBottomBarIndex = chosenBottomBarIndex,
                        onClick = { chosenBottomBarIndex = it },
                        itemIcon = Icons.Default.ShoppingCart,
                        itemTitle = "Cart"
                    )
                    BottomAppBarItem(
                        itemIndex = 2,
                        chosenBottomBarIndex = chosenBottomBarIndex,
                        onClick = { chosenBottomBarIndex = it },
                        itemIcon = Icons.Default.Notifications,
                        itemTitle = "Notification"
                    )
                    BottomAppBarItem(
                        itemIndex = 3,
                        chosenBottomBarIndex = chosenBottomBarIndex,
                        onClick = { chosenBottomBarIndex = it },
                        itemIcon = Icons.Default.Person,
                        itemTitle = "Profile"
                    )

                }
            }
        )
    }

}