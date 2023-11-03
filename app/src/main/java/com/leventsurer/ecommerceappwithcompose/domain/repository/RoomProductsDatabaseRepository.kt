package com.leventsurer.ecommerceappwithcompose.domain.repository

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel

interface RoomProductsDatabaseRepository {

    //Favorite Products
    suspend fun insertFavoriteProduct(favoriteProductModel: FavoriteProductModel)

    suspend fun deleteFavoriteProduct(favoriteProductModel: FavoriteProductModel)

    suspend fun getFavoriteProducts():List<FavoriteProductModel>

    //Products in cart

    suspend fun insertProductToCart(favoriteProductModel: ProductInCartModel)

    suspend fun deleteProductToCart(favoriteProductModel: ProductInCartModel)

    suspend fun getProductsToCart():List<ProductInCartModel>

}