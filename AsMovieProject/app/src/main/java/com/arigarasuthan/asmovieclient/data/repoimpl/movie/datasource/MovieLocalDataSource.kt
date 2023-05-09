package com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource

import com.arigarasuthan.asmovieclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}