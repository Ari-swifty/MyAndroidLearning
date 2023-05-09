package com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasourceimpl

import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}