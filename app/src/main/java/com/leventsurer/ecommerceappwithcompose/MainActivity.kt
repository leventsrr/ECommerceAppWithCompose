package com.leventsurer.ecommerceappwithcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.leventsurer.ecommerceappwithcompose.presentation.common.appbar.CustomBottomAppBar
import com.leventsurer.ecommerceappwithcompose.presentation.common.CustomTopAppBar
import com.leventsurer.ecommerceappwithcompose.presentation.common.NavHostContainer
import com.leventsurer.ecommerceappwithcompose.ui.theme.EcommerceAppWithComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)



        setContent {
            EcommerceAppWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    Scaffold(
                        topBar = {
                            CustomTopAppBar(
                                navBackStackEntry,
                                onBackClick = { navController.popBackStack() })

                        },
                        content = {
                            NavHostContainer(it, navController)
                        },
                        bottomBar = {
                            CustomBottomAppBar(navBackStackEntry)
                        }
                    )

                }
            }
        }
    }
}

