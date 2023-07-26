package com.sanchelo.retrofit.domain.di

import com.sanchelo.retrofit.data.repository.ProductsRepositoryImpl
import com.sanchelo.retrofit.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductsRepository(
        productsRepositoryImpl : ProductsRepositoryImpl
    ): ProductsRepository
}