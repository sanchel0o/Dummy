package com.sanchelo.dummy.domain.di

import com.sanchelo.dummy.data.repository.ProductsRepositoryImpl
import com.sanchelo.dummy.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
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
