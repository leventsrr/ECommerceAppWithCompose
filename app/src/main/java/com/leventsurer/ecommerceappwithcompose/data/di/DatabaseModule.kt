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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(
        app:Application,
        callback: ProductRoomDatabase.CallBack
    )= Room.databaseBuilder(app,ProductRoomDatabase::class.java,"product_database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideProductDao(db:ProductRoomDatabase)= db.productDao()

    @ApplicationScope
    @Provides
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())


}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope