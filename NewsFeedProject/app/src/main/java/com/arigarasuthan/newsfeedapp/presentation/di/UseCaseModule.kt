package com.arigarasuthan.newsfeedapp.presentation.di

import com.arigarasuthan.newsfeedapp.domain.repos.NewsRepo
import com.arigarasuthan.newsfeedapp.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providesGetNewsHeadlinesUseCase(newsRepo: NewsRepo) : GetNewsHeadlinesUseCase = GetNewsHeadlinesUseCase(newsRepo)

    @Singleton
    @Provides
    fun providesGetSearchedNewsUseCase(newsRepo: NewsRepo):GetSearchedNewsUseCase = GetSearchedNewsUseCase(newsRepo)

    @Singleton
    @Provides
    fun providesSaveNewsUseCase(newsRepo: NewsRepo):SaveNewsUseCase = SaveNewsUseCase(newsRepo)

    @Singleton
    @Provides
    fun providesGetSavedNewsUseCase(newsRepo: NewsRepo):GetSavedNewsUseCase = GetSavedNewsUseCase(newsRepo)

    @Singleton
    @Provides
    fun providesDeleteSavedNewsCase(newsRepo: NewsRepo):DeleteSavedNewsUseCase = DeleteSavedNewsUseCase(newsRepo)


}