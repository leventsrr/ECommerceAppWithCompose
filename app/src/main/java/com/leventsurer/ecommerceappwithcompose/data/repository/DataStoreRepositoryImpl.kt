package com.leventsurer.ecommerceappwithcompose.data.repository

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.leventsurer.ecommerceappwithcompose.data.di.userDataStore
import com.leventsurer.ecommerceappwithcompose.domain.repository.DataStoreRepository
import com.leventsurer.ecommerceappwithcompose.tools.Constants.USER_IS_LOGIN_STATE
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val context: Context
) : DataStoreRepository {
    private val userIsLoginStateKey = booleanPreferencesKey(USER_IS_LOGIN_STATE)
    override suspend fun setUserLoginStatus(isLogin: Boolean): Boolean {
        return try {
            context.userDataStore.edit { settings ->
                settings[userIsLoginStateKey] = isLogin
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getUserLoginStatus(): Boolean {
        val preference = context.userDataStore.data.first()
        return preference[userIsLoginStateKey] ?: false
    }
}