package com.sanchelo.dummy.domain.di

import com.sanchelo.dummy.data.repository.DummyRemoteRepositoryImpl
import com.sanchelo.dummy.domain.repository.DummyRemoteRepository
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
        productsRepositoryImpl : DummyRemoteRepositoryImpl
    ): DummyRemoteRepository
}
