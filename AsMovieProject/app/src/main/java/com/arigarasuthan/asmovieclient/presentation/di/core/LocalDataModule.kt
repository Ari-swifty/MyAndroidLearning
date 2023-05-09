package com.arigarasuthan.asmovieclient.presentation.di.core

import com.arigarasuthan.asmovieclient.data.db.ArtistDao
import com.arigarasuthan.asmovieclient.data.db.MovieDao
import com.arigarasuthan.asmovieclient.data.db.TvShowDao
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistLocalDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasourceimpl.ArtistsLocalDataSourceImpl
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieLocalDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowLocalDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistsLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource {
        return ArtistsLocalDataSourceImpl(artistDao)
    }



}