package com.leventsurer.ecommerceappwithcompose.domain.use_case.data_store

import com.leventsurer.ecommerceappwithcompose.domain.repository.DataStoreRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SetUserLoginStatusUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) {
    fun executeSetUserLoginStatus(isLogin: Boolean): Flow<Resource<Boolean>> = flow {
        try {
            emit(Resource.Loading())
            val isLoginState = dataStoreRepository.setUserLoginStatus(isLogin)
            emit(Resource.Success(isLoginState))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error"))
        }
    }


}