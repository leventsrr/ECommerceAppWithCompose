package com.leventsurer.ecommerceappwithcompose.data.repository

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductDao
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Product
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomDatabaseRepository
import javax.inject.Inject

class RoomDatabaseRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
):RoomDatabaseRepository {

    override suspend fun insertProduct(productModel: ProductModel){
        productDao.addProduct(productModel)
    }


    override suspend fun updateProductDetail(productModel: ProductModel){
        productDao.updateProductDetails(productModel)
    }

    override suspend fun deleteProduct(productModel: ProductModel){
        productDao.deleteProduct(productModel)
    }

     override fun getProducts():ArrayList<ProductModel>{
        return productDao.getProducts()
    }
}