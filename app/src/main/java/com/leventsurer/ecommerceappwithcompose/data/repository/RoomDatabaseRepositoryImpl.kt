package com.leventsurer.ecommerceappwithcompose.data.repository

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductDao
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomDatabaseRepository
import javax.inject.Inject

class RoomDatabaseRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
):RoomDatabaseRepository {

    override suspend fun insertProduct(favoriteProductModel: FavoriteProductModel){
        productDao.addProduct(favoriteProductModel)
    }


    override suspend fun updateProductDetail(favoriteProductModel: FavoriteProductModel){
        productDao.updateProductDetails(favoriteProductModel)
    }

    override suspend fun deleteProduct(favoriteProductModel: FavoriteProductModel){
        productDao.deleteProduct(favoriteProductModel)
    }

     override suspend fun getProducts():List<FavoriteProductModel>{
        return productDao.getProducts()
    }
}