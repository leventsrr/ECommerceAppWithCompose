package com.leventsurer.ecommerceappwithcompose.domain.use_case.room

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Product
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomDatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val roomDatabaseRepository: RoomDatabaseRepository
) {

    fun executeAddProductUseCase(productModel: ProductModel): Flow<Resource<Boolean>> = flow {
       try {
           emit(Resource.Loading())
           roomDatabaseRepository.insertProduct(productModel)
           emit(Resource.Success(true))
       }catch (e:Exception){
           emit(Resource.Error(e.message ?: "Error"))
       }
    }

}