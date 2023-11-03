package com.leventsurer.ecommerceappwithcompose.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {

    //Favorite Product
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteProduct(favoriteProductModel: FavoriteProductModel)

    @Query("SELECT * FROM favorite_product")
    suspend fun getFavoriteProducts():List<FavoriteProductModel>

    @Update
    suspend fun updateFavoriteProductDetails(favoriteProductModel: FavoriteProductModel)

    @Delete
    suspend fun deleteFavoriteProduct(favoriteProductModel: FavoriteProductModel)

    //Products in cart

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProductToCart(favoriteProductModel: FavoriteProductModel)

    @Query("SELECT * FROM product_in_cart")
    suspend fun getProductsToCart():List<ProductInCartModel>

    @Update
    suspend fun updateProductDetailsToCart(favoriteProductModel: ProductInCartModel)

    @Delete
    suspend fun deleteProductToCart(favoriteProductModel: ProductInCartModel)

}