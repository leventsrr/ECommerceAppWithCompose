package com.leventsurer.ecommerceappwithcompose.domain.use_case.room

import android.util.Log
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomDatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val roomDatabaseRepository: RoomDatabaseRepository
) {

    fun executeAddProductUseCase(favoriteProductModel: FavoriteProductModel): Flow<Resource<Boolean>> = flow {
       try {
           emit(Resource.Loading())
           roomDatabaseRepository.insertProduct(favoriteProductModel)
           emit(Resource.Success(true))
       }catch (e:Exception){
           Log.e("kontrol","suecase add error:${e.message}")
           emit(Resource.Error(e.message ?: "Error"))
       }
    }

}