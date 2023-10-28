package com.leventsurer.ecommerceappwithcompose.data.repository

import android.util.Log
import com.leventsurer.ecommerceappwithcompose.data.remote.CategoryApi
import com.leventsurer.ecommerceappwithcompose.data.remote.ProductApi
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.CategoriesResponse
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.domain.repository.DatabaseRepository
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val categoryApi: CategoryApi,
    private val productApi: ProductApi,
) : DatabaseRepository {
    override suspend fun getAllCategories(): CategoriesResponse {
        return categoryApi.getAllCategories()
    }

    override suspend fun getProductsInCategory(categoryName: String): ArrayList<GetProductResponse> {
        return productApi.getProductsInCategory(categoryName)
    }

}