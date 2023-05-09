package com.arigarasuthan.asmovieclient.presentation.di.core

import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistCacheDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasourceimpl.ArtistCacheDataSourceImpl
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieCacheDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowCacheDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource = MovieCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource = TvShowCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource = ArtistCacheDataSourceImpl()


}