package com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomProductsDatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddFavoriteProductUseCase @Inject constructor(
    private val roomProductsDatabaseRepository: RoomProductsDatabaseRepository
) {
    fun executeAddProductUseCase(favoriteProductModel: FavoriteProductModel): Flow<Resource<Boolean>> =
        flow {
            try {
                emit(Resource.Loading())
                roomProductsDatabaseRepository.insertFavoriteProduct(favoriteProductModel)
                emit(Resource.Success(true))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
            }
        }
}