package com.leventsurer.ecommerceappwithcompose.data.local.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Product

interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(productModel: ProductModel)

    @Query("SELECT * FROM product")
    fun getProducts():ArrayList<ProductModel>

    @Update
    suspend fun updateProductDetails(productModel: ProductModel)

    @Delete
    suspend fun deleteProduct(productModel: ProductModel)
}