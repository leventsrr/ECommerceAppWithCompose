package com.leventsurer.ecommerceappwithcompose.presentation.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.leventsurer.ecommerceappwithcompose.presentation.categories_screen.view.CategoriesScreen
import com.leventsurer.ecommerceappwithcompose.presentation.cart_screen.view.CartScreen
import com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen.view.FavoriteProductsScreen
import com.leventsurer.ecommerceappwithcompose.presentation.home_screen.view.HomeScreen
import com.leventsurer.ecommerceappwithcompose.presentation.login_screen.view.LoginScreen
import com.leventsurer.ecommerceappwithcompose.presentation.on_boarding_screen.view.OnBoardingScreen
import com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen.view.ProductDetailScreen
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.view.ProductsInCategoryScreen
import com.leventsurer.ecommerceappwithcompose.presentation.profile_screen.view.ProfileScreen
import com.leventsurer.ecommerceappwithcompose.presentation.register_screen.view.RegisterScreen
import com.leventsurer.ecommerceappwithcompose.presentation.splash_screen.view.SplashScreen
import com.leventsurer.ecommerceappwithcompose.ui.Screens

@Composable
fun NavHostContainer(scaffoldPadding: PaddingValues, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(Screens.SplashScreen.route) {
            SplashScreen(
                scaffoldPadding = scaffoldPadding,
                onSignUpNavigateClick = {
                    navController.navigate(Screens.OnBoardingScreen.route)
                },
                onLoginNavigateClick = {
                    navController.navigate(Screens.LoginScreen.route)
                },
                navigateHomePage = {
                    navController.navigate(Screens.HomeScreen.route)
                }
            )
        }
        composable(Screens.RegisterScreen.route) {
            RegisterScreen(
                scaffoldPadding,
                onLoginClick = {
                    navController.navigate(Screens.HomeScreen.route)
                }
            )
        }
        composable(
            route = "${Screens.ProductDetailScreen.route}/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStackEntry ->
            ProductDetailScreen(
                scaffoldPadding,
                productId = backStackEntry.arguments?.getString("productId")
            )
        }
        composable(
            route = "${Screens.ProductsInCategoryScreen.route}/{categoryName}",
            arguments = listOf(navArgument("categoryName") { type = NavType.StringType })
        ) { backStackEntry ->
            ProductsInCategoryScreen(
                categoryName = backStackEntry.arguments?.getString("categoryName")!!,
                paddingValues = scaffoldPadding,
                navHostController = navController
            )
        }
        composable(Screens.OnBoardingScreen.route) {
            OnBoardingScreen(
                navigateToRegister = {
                    navController.navigate(Screens.RegisterScreen.route)
                }
            )
        }
        composable(Screens.LoginScreen.route) {
            LoginScreen(padding = scaffoldPadding,
                navigateToHomePage = { navController.navigate(Screens.HomeScreen.route) })
        }
        composable(
            route = Screens.HomeScreen.route,
        ) {
            HomeScreen(
                paddingValues = scaffoldPadding,
                navigateToCategoriesPage = { navController.navigate(Screens.CategoriesScreen.route) },
                navHostController = navController
            )
        }
        composable(Screens.CategoriesScreen.route) {
            CategoriesScreen(scaffoldPadding, navHostController = navController)
        }
        composable(Screens.CartScreen.route) {
            CartScreen(
                paddingValues = scaffoldPadding
            )
        }
        composable(Screens.FavoriteProductsScreen.route) {
            FavoriteProductsScreen(
                navHostController = navController,
                paddingValues = scaffoldPadding
            )
        }
        composable(Screens.ProfileScreen.route) {
            ProfileScreen(
                paddingValues = scaffoldPadding
            )
        }
    }
}
