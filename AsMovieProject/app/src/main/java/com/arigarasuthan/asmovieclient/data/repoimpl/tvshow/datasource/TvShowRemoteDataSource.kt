package com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource

import com.arigarasuthan.asmovieclient.data.model.movie.MovieList
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}