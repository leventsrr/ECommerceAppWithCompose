package com.leventsurer.ecommerceappwithcompose.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(favoriteProductModel: FavoriteProductModel)

    @Query("SELECT * FROM product")
    suspend fun getProducts():List<FavoriteProductModel>

    @Update
    suspend fun updateProductDetails(favoriteProductModel: FavoriteProductModel)

    @Delete
    suspend fun deleteProduct(favoriteProductModel: FavoriteProductModel)
}