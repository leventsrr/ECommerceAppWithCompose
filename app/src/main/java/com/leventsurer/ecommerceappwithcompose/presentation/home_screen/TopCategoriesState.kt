package com.leventsurer.ecommerceappwithcompose.presentation.home_screen

data class TopCategoriesState(
    val isLoading : Boolean = false,
    val error : String? = null,
    val topCategories : ArrayList<String>? = null
)
