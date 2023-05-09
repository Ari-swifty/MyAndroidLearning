package com.arigarasuthan.asmovieclient.presentation.di.core

import com.arigarasuthan.asmovieclient.data.domain.repo.ArtistRepo
import com.arigarasuthan.asmovieclient.data.domain.repo.MovieRepo
import com.arigarasuthan.asmovieclient.data.domain.repo.TvShowsRepo
import com.arigarasuthan.asmovieclient.data.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepo: MovieRepo): GetMovieUseCase = GetMovieUseCase(movieRepo)

    @Provides
    fun provideUpdateMovieUseCase(movieRepo: MovieRepo): UpdateMoviesUseCase =
        UpdateMoviesUseCase(movieRepo)

    @Provides
    fun provideGetTvShowUseCase(tvShowsRepo: TvShowsRepo): GetTvShowsUseCase =
        GetTvShowsUseCase(tvShowsRepo)

    @Provides
    fun provideUpdateTvShowUseCase(tvShowsRepo: TvShowsRepo): UpdateTvShowsUseCase =
        UpdateTvShowsUseCase(tvShowsRepo)

    @Provides
    fun provideGetArtistUseCase(artistRepo: ArtistRepo): GetArtistsUseCases =
        GetArtistsUseCases(artistRepo)

    @Provides
    fun provideUpdateArtistUseCase(artistRepo: ArtistRepo): UpdateArtistsUseCase =
        UpdateArtistsUseCase(artistRepo)
}