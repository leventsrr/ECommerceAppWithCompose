package com.leventsurer.ecommerceappwithcompose.data.di

import com.leventsurer.ecommerceappwithcompose.data.remote.AuthenticationApi
import com.leventsurer.ecommerceappwithcompose.data.remote.CategoryApi
import com.leventsurer.ecommerceappwithcompose.data.remote.ProductApi
import com.leventsurer.ecommerceappwithcompose.tools.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    @Singleton
    fun provideAuthenticationApi(): AuthenticationApi =Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AuthenticationApi::class.java)



    @Provides
    @Singleton
    fun provideCategoryApi(): CategoryApi  =Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CategoryApi::class.java)

    @Provides
    @Singleton
    fun provideProductApi(): ProductApi  =Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductApi::class.java)



}