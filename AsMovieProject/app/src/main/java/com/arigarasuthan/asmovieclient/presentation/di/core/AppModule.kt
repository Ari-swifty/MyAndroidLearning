package com.arigarasuthan.asmovieclient.presentation.di.core

import android.content.Context
import com.arigarasuthan.asmovieclient.presentation.di.artist.ArtistSubComponent
import com.arigarasuthan.asmovieclient.presentation.di.movie.MoviesSubComponent
import com.arigarasuthan.asmovieclient.presentation.di.tvshow.TvShowsSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MoviesSubComponent::class,TvShowsSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context {
        return context.applicationContext
    }
 }