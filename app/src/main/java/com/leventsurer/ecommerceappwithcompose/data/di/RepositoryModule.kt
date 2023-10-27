package com.leventsurer.ecommerceappwithcompose.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.leventsurer.ecommerceappwithcompose.data.remote.AuthenticationApi
import com.leventsurer.ecommerceappwithcompose.data.repository.AuthenticationRepositoryImpl
import com.leventsurer.ecommerceappwithcompose.data.repository.DataStoreRepositoryImpl
import com.leventsurer.ecommerceappwithcompose.domain.repository.AuthenticationRepository
import com.leventsurer.ecommerceappwithcompose.domain.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.userDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "dataStorePreferences"
)
@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthenticationRepository(authenticationApi: AuthenticationApi) : AuthenticationRepository {
        return AuthenticationRepositoryImpl(authenticationApi)
    }



    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ) : DataStoreRepository = DataStoreRepositoryImpl(context)

}