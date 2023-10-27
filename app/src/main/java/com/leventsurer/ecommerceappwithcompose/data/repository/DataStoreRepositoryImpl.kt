package com.leventsurer.ecommerceappwithcompose.data.repository

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.leventsurer.ecommerceappwithcompose.data.di.userDataStore
import com.leventsurer.ecommerceappwithcompose.domain.repository.DataStoreRepository
import com.leventsurer.ecommerceappwithcompose.tools.Constants.DATASTORE_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val context: Context
) : DataStoreRepository {

    private val dataStoreKey = booleanPreferencesKey(DATASTORE_KEY)

    override suspend fun setUserLoginStatus(isLogin: Boolean): Boolean {
        return try {
            context.userDataStore.edit { settings ->
                settings[dataStoreKey] = isLogin
            }
            true
        }catch (e:Exception){
            false
        }

    }

    override suspend fun getUserLoginStatus(): Boolean {
        val preference =  context.userDataStore.data.first()
        return preference[dataStoreKey] ?: false
    }
}