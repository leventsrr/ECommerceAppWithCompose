package com.leventsurer.ecommerceappwithcompose.data.di

import com.leventsurer.ecommerceappwithcompose.data.remote.AuthenticationApi
import com.leventsurer.ecommerceappwithcompose.data.repository.AuthenticationRepositoryImpl
import com.leventsurer.ecommerceappwithcompose.domain.repository.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

@Provides
    @Singleton
    fun provideAuthenticationRepository(authenticationApi: AuthenticationApi) : AuthenticationRepository {
        return AuthenticationRepositoryImpl(authenticationApi)
    }
}