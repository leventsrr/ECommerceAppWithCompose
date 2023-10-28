package com.leventsurer.ecommerceappwithcompose.domain.use_case.data_store

import android.util.Log
import com.leventsurer.ecommerceappwithcompose.domain.repository.DataStoreRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject



class GetUserLoginStatusUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    fun executeGetUserLoginStatus(): Flow<Resource<Boolean>> = flow {
        try {
            emit(Resource.Loading())
            val isLoginState = dataStoreRepository.getUserLoginStatus()
            emit(Resource.Success(isLoginState))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error"))
        }
    }


}