package com.leventsurer.ecommerceappwithcompose.data.repository

import androidx.compose.runtime.produceState
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductDao
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomProductsDatabaseRepository
import javax.inject.Inject

class RoomProductsDatabaseRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
): RoomProductsDatabaseRepository {
    //Favorite Products
    override suspend fun insertFavoriteProduct(favoriteProductModel: FavoriteProductModel){
        productDao.addFavoriteProduct(favoriteProductModel)
    }

    override suspend fun deleteFavoriteProduct(favoriteProductModel: FavoriteProductModel){
        productDao.deleteFavoriteProduct(favoriteProductModel)
    }

     override suspend fun getFavoriteProducts():List<FavoriteProductModel>{
        return productDao.getFavoriteProducts()
    }
    
    //Products in cart
    override suspend fun insertProductToCart(productInCartModel: ProductInCartModel) {
        productDao.addProductToCart(productInCartModel)
    }

    override suspend fun deleteProductToCart(productInCartModel: ProductInCartModel) {
        productDao.deleteProductToCart(productInCartModel)
    }

    override suspend fun getProductsToCart(): List<ProductInCartModel> {
        return productDao.getProductsToCart()
    }
}