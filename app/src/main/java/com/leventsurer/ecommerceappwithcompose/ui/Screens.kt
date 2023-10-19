package com.leventsurer.ecommerceappwithcompose.ui

sealed class Screens (val route:String){
    object SplashScreen:Screens("splash_screen")
    object RegisterScreen:Screens("register_screen")
    object ProductDetailScreen:Screens("product_detail_screen")
    object OnBoardingScreen:Screens("on_boarding_screen")
    object LoginScreen:Screens("login_screen")
    object HomeScreen:Screens("home_screen")
    object CategoriesScreen:Screens("categories_screen")




}
