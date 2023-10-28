package com.leventsurer.ecommerceappwithcompose.domain.repository

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.CategoriesResponse
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse

interface DatabaseRepository {

    suspend fun getAllCategories() : CategoriesResponse

    suspend fun getProductsInCategory(categoryName:String):ArrayList<GetProductResponse>

    suspend fun getAllProducts():ArrayList<GetProductResponse>
}