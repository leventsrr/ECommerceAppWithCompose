package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

data class ProductsInCategoryState(
    val isLoading : Boolean = false,
    val error : String? = null,
    val productsInCategory : ArrayList<GetProductResponse>? = null
)
