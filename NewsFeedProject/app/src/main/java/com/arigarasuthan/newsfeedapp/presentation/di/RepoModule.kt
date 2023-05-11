package com.arigarasuthan.newsfeedapp.presentation.di

import com.arigarasuthan.newsfeedapp.data.repo.NewsRepoImpl
import com.arigarasuthan.newsfeedapp.data.repo.datasource.NewsRemoteDataSource
import com.arigarasuthan.newsfeedapp.domain.repos.NewsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Singleton
    @Provides
    fun providesNewsRepo(newsRemoteDataSource: NewsRemoteDataSource) : NewsRepo = NewsRepoImpl(newsRemoteDataSource)
}