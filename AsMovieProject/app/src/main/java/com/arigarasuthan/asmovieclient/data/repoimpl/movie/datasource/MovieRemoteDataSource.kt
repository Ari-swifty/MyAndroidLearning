package com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource

import com.arigarasuthan.asmovieclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}