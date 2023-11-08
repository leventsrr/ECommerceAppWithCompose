package com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.domain.repository.DatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.random.Random

class GetAllProductsUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    fun executeGetAllProducts(): Flow<Resource<ArrayList<GetProductResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val products = databaseRepository.getAllProducts()
            emit(Resource.Success(products))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error"))
        }
    }

    fun executeGetRandomProductsInAll(): Flow<Resource<ArrayList<GetProductResponse>>> = flow {
        val randomProducts = arrayListOf<GetProductResponse>()
        val randomIndexes = arrayListOf<Int>()
        try {
            emit(Resource.Loading())
            val products = databaseRepository.getAllProducts()
            while (randomIndexes.size < 6) {
                val randomProductIndex = Random.nextInt(products.size)
                if (randomProductIndex !in randomIndexes) {
                    randomIndexes.add(randomProductIndex)
                }
            }
            randomIndexes.forEach {
                randomProducts.add(products[it])
            }
            emit(Resource.Success(randomProducts))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}