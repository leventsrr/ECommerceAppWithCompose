package com.leventsurer.ecommerceappwithcompose.domain.use_case.room

import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomDatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val roomDatabaseRepository: RoomDatabaseRepository
) {

    fun executeGetProducts():Flow<Resource<List<FavoriteProductModel>>> = flow {
        try {
            emit(Resource.Loading())
            val products = roomDatabaseRepository.getProducts()
            emit(Resource.Success(products))
        }catch (e:Exception){
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}