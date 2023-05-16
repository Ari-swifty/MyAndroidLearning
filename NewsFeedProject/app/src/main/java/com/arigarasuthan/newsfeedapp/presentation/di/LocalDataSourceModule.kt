package com.arigarasuthan.newsfeedapp.presentation.di

import com.arigarasuthan.newsfeedapp.data.db.ArticleDao
import com.arigarasuthan.newsfeedapp.data.repo.datasource.NewsLocalDataSource
import com.arigarasuthan.newsfeedapp.data.repo.datasourceimpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(articleDao: ArticleDao):NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDao)
    }
}