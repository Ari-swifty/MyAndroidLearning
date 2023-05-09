package com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasourceimpl

import com.arigarasuthan.asmovieclient.data.db.MovieDao
import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)

        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}