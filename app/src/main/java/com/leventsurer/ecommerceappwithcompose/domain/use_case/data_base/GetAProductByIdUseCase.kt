package com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base

import android.util.Log
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.domain.repository.DatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAProductByIdUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    fun executeGetAProductById(productId:String) : Flow<Resource<GetProductResponse>> = flow {
        try {
            emit(Resource.Loading())
            val product = databaseRepository.getAProductById(productId)
            emit(Resource.Success(product))
        }catch (e:Exception){
            Log.e("kontrol","usecase error : ${e.message}")
            emit(Resource.Error(e.message ?: "Error"))
        }


    }
}