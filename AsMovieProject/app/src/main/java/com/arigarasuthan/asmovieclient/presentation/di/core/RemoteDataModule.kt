package com.arigarasuthan.asmovieclient.presentation.di.core

import com.arigarasuthan.asmovieclient.api.TMTBService
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistRemoteDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasourceimpl.ArtistsRemoteDataSourceImpl
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieRemoteDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowRemoteDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmtbService: TMTBService) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmtbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmtbService: TMTBService) : TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmtbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmtbService: TMTBService) : ArtistRemoteDataSource {
        return ArtistsRemoteDataSourceImpl(tmtbService,apiKey)
    }


}