package com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomProductsDatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFavoriteProductsUseCase @Inject constructor(
    private val roomProductsDatabaseRepository: RoomProductsDatabaseRepository
) {
    fun executeGetProducts(): Flow<Resource<List<FavoriteProductModel>>> = flow {
        try {
            emit(Resource.Loading())
            val products = roomProductsDatabaseRepository.getFavoriteProducts()
            emit(Resource.Success(products))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}