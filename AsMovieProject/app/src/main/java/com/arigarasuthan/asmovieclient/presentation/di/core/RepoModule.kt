package com.arigarasuthan.asmovieclient.presentation.di.core

import com.arigarasuthan.asmovieclient.data.domain.repo.ArtistRepo
import com.arigarasuthan.asmovieclient.data.domain.repo.MovieRepo
import com.arigarasuthan.asmovieclient.data.domain.repo.TvShowsRepo
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.ArtistRepoImpl
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistCacheDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistLocalDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistRemoteDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.MovieRepoImpl
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieCacheDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieLocalDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieRemoteDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.TvShowRepoImpl
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowCacheDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowLocalDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepo {
        return MovieRepoImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepo {
        return TvShowRepoImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepo {
        return ArtistRepoImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}