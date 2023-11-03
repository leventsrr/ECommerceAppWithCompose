package com.leventsurer.ecommerceappwithcompose.domain.repository

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel

interface RoomDatabaseRepository {

    suspend fun insertProduct(favoriteProductModel: FavoriteProductModel)


    suspend fun updateProductDetail(favoriteProductModel: FavoriteProductModel)

    suspend fun deleteProduct(favoriteProductModel: FavoriteProductModel)

    suspend fun getProducts():List<FavoriteProductModel>

}