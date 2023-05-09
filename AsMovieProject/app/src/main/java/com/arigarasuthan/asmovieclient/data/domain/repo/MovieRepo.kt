package com.arigarasuthan.asmovieclient.data.domain.repo

import com.arigarasuthan.asmovieclient.data.model.movie.Movie

interface MovieRepo {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}