package com.leventsurer.ecommerceappwithcompose.presentation.categories_screen

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.CategoriesResponse

data class CategoriesState (
    val isLoading : Boolean = false,
    val error : String? = null,
    val categories : CategoriesResponse? = null
)