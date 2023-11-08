package com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetAllCartsResponse
import com.leventsurer.ecommerceappwithcompose.domain.repository.DatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllPastCartsUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    fun executeGetAllPastCarts():Flow<Resource<ArrayList<GetAllCartsResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val pastCarts = databaseRepository.getAllPastCarts()
            emit(Resource.Success(pastCarts))
        }catch (e:Exception){
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}