package com.sanchelo.dummy.domain.di

import com.sanchelo.dummy.domain.use_cases.GetProductDataUseCase
import com.sanchelo.dummy.domain.use_cases.GetProductDataUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindGetProductDataUseCase(
        getProductDataUseCaseImpl : GetProductDataUseCaseImpl
    ): GetProductDataUseCase
}