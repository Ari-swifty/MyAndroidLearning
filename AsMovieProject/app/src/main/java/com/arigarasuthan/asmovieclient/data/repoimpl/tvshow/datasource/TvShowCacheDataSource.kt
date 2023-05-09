package com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource

import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}