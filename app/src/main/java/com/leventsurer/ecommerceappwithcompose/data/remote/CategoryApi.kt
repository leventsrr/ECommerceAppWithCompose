package com.leventsurer.ecommerceappwithcompose.data.remote

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.CategoriesResponse
import retrofit2.http.GET

interface CategoryApi {
    @GET("products/categories")
    suspend fun getAllCategories() : CategoriesResponse
}