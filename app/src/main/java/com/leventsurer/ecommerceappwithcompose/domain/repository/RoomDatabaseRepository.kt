package com.leventsurer.ecommerceappwithcompose.domain.repository

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Product

interface RoomDatabaseRepository {

    suspend fun insertProduct(productModel: ProductModel)


    suspend fun updateProductDetail(productModel: ProductModel)

    suspend fun deleteProduct(productModel: ProductModel)

    fun getProducts():ArrayList<ProductModel>

}