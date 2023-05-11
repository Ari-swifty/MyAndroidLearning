package com.arigarasuthan.newsfeedapp.presentation.di

import com.arigarasuthan.newsfeedapp.data.api.NewsApiService
import com.arigarasuthan.newsfeedapp.data.repo.datasource.NewsRemoteDataSource
import com.arigarasuthan.newsfeedapp.data.repo.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun providesNewsRemoteDataSourceModule(newsApiService: NewsApiService): NewsRemoteDataSource =
        NewsRemoteDataSourceImpl(newsApiService)
}