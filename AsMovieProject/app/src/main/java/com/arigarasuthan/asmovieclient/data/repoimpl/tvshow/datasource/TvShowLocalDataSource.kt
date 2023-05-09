package com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource

import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowsToDB(tvShows:List<TvShow>)
    suspend fun clearAll()
}