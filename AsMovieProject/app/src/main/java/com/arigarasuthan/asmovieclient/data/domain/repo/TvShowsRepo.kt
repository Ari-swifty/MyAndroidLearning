package com.arigarasuthan.asmovieclient.data.domain.repo

import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow

interface TvShowsRepo {
    suspend fun getTvShows():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?
}