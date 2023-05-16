package com.arigarasuthan.newsfeedapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.arigarasuthan.newsfeedapp.data.db.ArticleDao
import com.arigarasuthan.newsfeedapp.data.db.ArticleDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun providesNewsDataBase(app:Application):ArticleDataBase {
        return Room.databaseBuilder(app,ArticleDataBase::class.java,"news_Db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(articleDataBase: ArticleDataBase):ArticleDao {
        return articleDataBase.getArticleDao()
    }
}