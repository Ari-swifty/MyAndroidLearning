package com.arigarasuthan.asmovieclient.data.domain.usecase

import com.arigarasuthan.asmovieclient.data.domain.repo.MovieRepo
import com.arigarasuthan.asmovieclient.data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepo: MovieRepo) {
    suspend fun execute():List<Movie>? = movieRepo.updateMovies()

}