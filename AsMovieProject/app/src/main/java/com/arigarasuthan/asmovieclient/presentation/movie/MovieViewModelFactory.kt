package com.arigarasuthan.asmovieclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arigarasuthan.asmovieclient.data.domain.usecase.GetMovieUseCase
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase,updateMoviesUseCase) as T
    }
}