package com.leventsurer.ecommerceappwithcompose.presentation.categories_screen

import com.leventsurer.ecommerceappwithcompose.domain.model.CategoryProductQuantityModel

data class ProductState (
    val isLoading : Boolean = false,
    val error : String? = null,
    val productsAndQuantity : ArrayList<CategoryProductQuantityModel>? = null
)
