package com.leventsurer.ecommerceappwithcompose.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.RoomDatabase
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductDao
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductRoomDatabase
import com.leventsurer.ecommerceappwithcompose.data.remote.AuthenticationApi
import com.leventsurer.ecommerceappwithcompose.data.remote.CartApi
import com.leventsurer.ecommerceappwithcompose.data.remote.CategoryApi
import com.leventsurer.ecommerceappwithcompose.data.remote.ProductApi
import com.leventsurer.ecommerceappwithcompose.data.repository.AuthenticationRepositoryImpl
import com.leventsurer.ecommerceappwithcompose.data.repository.DataStoreRepositoryImpl
import com.leventsurer.ecommerceappwithcompose.data.repository.DatabaseRepositoryImpl
import com.leventsurer.ecommerceappwithcompose.data.repository.RoomDatabaseRepositoryImpl
import com.leventsurer.ecommerceappwithcompose.domain.repository.AuthenticationRepository
import com.leventsurer.ecommerceappwithcompose.domain.repository.DataStoreRepository
import com.leventsurer.ecommerceappwithcompose.domain.repository.DatabaseRepository
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomDatabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
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

    @Provides
    @Singleton
    fun provideDatabaseRepository(categoryApi: CategoryApi,productApi: ProductApi,cartApi: CartApi) : DatabaseRepository {
        return DatabaseRepositoryImpl(categoryApi =  categoryApi, productApi = productApi, cartApi = cartApi)
    }

   @Provides
    @Singleton
    fun provideRoomRepository(productDao: ProductDao) : RoomDatabaseRepository {
        return RoomDatabaseRepositoryImpl(productDao = productDao)
    }



    @Provides
    fun provideFavoriteProductDao(db:ProductRoomDatabase)= db.productDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())


}