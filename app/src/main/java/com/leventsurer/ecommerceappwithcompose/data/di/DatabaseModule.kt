package com.leventsurer.ecommerceappwithcompose.data.di

import android.app.Application
import android.content.Context
import androidx.room.Insert
import androidx.room.Room
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductDao
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {



    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): ProductRoomDatabase {
        return Room.databaseBuilder(
            appContext,
            ProductRoomDatabase::class.java,
            "product"
        ).build()
    }



    @Provides
    @Singleton
    fun provideChannelDao(productRoomDatabase: ProductRoomDatabase): ProductDao {
        return productRoomDatabase.productDao()
    }


}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope