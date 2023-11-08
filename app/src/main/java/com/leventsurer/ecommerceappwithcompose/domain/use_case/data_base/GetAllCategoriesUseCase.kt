package com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.CategoriesResponse
import com.leventsurer.ecommerceappwithcompose.domain.repository.DatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    fun executeGetUAllCategories(): Flow<Resource<CategoriesResponse>> = flow {
        try {
            emit(Resource.Loading())
            val categories = databaseRepository.getAllCategories()
            emit(Resource.Success(categories))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}