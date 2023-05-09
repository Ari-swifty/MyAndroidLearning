package com.arigarasuthan.asmovieclient.presentation.di

import com.arigarasuthan.asmovieclient.api.TMTBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMTBService(retrofit: Retrofit) : TMTBService {
        return retrofit.create(TMTBService::class.java)
    }
}