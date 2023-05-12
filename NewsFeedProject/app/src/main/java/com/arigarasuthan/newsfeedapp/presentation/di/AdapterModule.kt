package com.arigarasuthan.newsfeedapp.presentation.di

import com.arigarasuthan.newsfeedapp.presentation.adapter.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Singleton
    @Provides
    fun provideNewsAdapter():NewsAdapter = NewsAdapter()
}