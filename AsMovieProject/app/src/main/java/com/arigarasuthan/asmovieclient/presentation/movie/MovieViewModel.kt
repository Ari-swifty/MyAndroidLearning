package com.arigarasuthan.asmovieclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.arigarasuthan.asmovieclient.data.domain.usecase.GetMovieUseCase
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}