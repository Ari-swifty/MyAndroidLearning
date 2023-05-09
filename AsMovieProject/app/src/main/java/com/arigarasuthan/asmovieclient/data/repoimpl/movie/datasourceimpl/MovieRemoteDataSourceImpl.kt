package com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasourceimpl

import com.arigarasuthan.asmovieclient.api.TMTBService
import com.arigarasuthan.asmovieclient.data.model.movie.MovieList
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmtbService: TMTBService,private val apiKey:String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList>  = tmtbService.getPopularMovies(apiKey)
}