package com.arigarasuthan.newsfeedapp.presentation.di

import android.app.Application
import com.arigarasuthan.newsfeedapp.domain.usecases.GetNewsHeadlinesUseCase
import com.arigarasuthan.newsfeedapp.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun providesViewModelFactory(application: Application,getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase) : NewsViewModelFactory {
        return NewsViewModelFactory(application,getNewsHeadlinesUseCase)
    }
}