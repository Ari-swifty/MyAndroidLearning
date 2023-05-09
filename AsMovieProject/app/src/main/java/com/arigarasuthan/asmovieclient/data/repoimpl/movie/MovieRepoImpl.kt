package com.arigarasuthan.asmovieclient.data.repoimpl.movie

import android.util.Log
import com.arigarasuthan.asmovieclient.data.domain.repo.MovieRepo
import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieCacheDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieLocalDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieRemoteDataSource

class MovieRepoImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepo {
    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie> {
        var movieList:List<Movie> = ArrayList()

        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body!=null) {
                    movieList = body.movies
            }
        }catch (exception:java.lang.Exception)
        {
            Log.d("MyTag",exception.message.toString())
        }

        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie> {
        var movieList:List<Movie> = ArrayList()

        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception:java.lang.Exception)
        {
            Log.d("MyTag",exception.message.toString())
        }
        if(movieList.isNotEmpty()) {
            return movieList
        }
        else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie> {
        var movieList:List<Movie> = ArrayList()

        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception:java.lang.Exception)
        {
            Log.d("MyTag",exception.message.toString())
        }
        if(movieList.isNotEmpty()) {
            return movieList
        }
        else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}