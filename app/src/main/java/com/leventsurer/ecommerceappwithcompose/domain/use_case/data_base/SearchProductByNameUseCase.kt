package com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.domain.repository.DatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchProductByNameUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    fun executeSearchProductByName(productName: String): Flow<Resource<List<GetProductResponse>>> =
        flow {
            try {
                emit(Resource.Loading())
                val products = databaseRepository.getAllProducts()
                if(!products.isNullOrEmpty()){
                    emit(Resource.Success(products.filter { product ->
                        product.title.uppercase().contains(productName.uppercase())
                    }))
                }else{
                    emit(Resource.Success(arrayListOf()))
                }

            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
            }
        }
}