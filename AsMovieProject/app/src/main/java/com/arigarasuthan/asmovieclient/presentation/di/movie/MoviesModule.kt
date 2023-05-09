package com.arigarasuthan.asmovieclient.presentation.di.movie

import com.arigarasuthan.asmovieclient.data.domain.usecase.GetMovieUseCase
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateMoviesUseCase
import com.arigarasuthan.asmovieclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MoviesModule {

    @MovieScope
    @Provides
    fun provideMoviesViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase,updateMoviesUseCase)
    }
}