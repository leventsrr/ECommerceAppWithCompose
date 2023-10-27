package com.leventsurer.ecommerceappwithcompose.domain.repository

interface DataStoreRepository {

    suspend fun setUserLoginStatus(isLogin:Boolean) : Boolean
    suspend fun getUserLoginStatus() : Boolean

}