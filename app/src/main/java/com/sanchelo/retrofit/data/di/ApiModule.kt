package com.sanchelo.retrofit.data.di

import com.sanchelo.retrofit.data.api.ProductsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//AppModule dependencies live as long as app does
@Module
@InstallIn(SingletonComponent::class) //defines how long the component actually lives. Decides about the lifetime
object ApiModule {

    @Provides //provides the dependency
    @Singleton //How many of these dependencies we have. Singleton for a single instance for the whole lifetime of App
    fun provideMainApi(client: OkHttpClient): ProductsAPI {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsAPI::class.java)
    }
}