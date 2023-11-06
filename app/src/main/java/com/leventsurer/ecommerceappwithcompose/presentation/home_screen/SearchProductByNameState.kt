package com.leventsurer.ecommerceappwithcompose.presentation.home_screen

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

data class SearchProductByNameState(
    val isLoading:Boolean? = null,
    val error : String? = null,
    val products : List<GetProductResponse>?  = null
)
