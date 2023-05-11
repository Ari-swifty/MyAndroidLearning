package com.arigarasuthan.newsfeedapp.presentation.di

import com.arigarasuthan.newsfeedapp.domain.repos.NewsRepo
import com.arigarasuthan.newsfeedapp.domain.usecases.GetNewsHeadlinesUseCase
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
}