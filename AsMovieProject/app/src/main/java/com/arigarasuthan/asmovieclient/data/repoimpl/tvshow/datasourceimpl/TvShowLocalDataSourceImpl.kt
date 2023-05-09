package com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasourceimpl

import com.arigarasuthan.asmovieclient.data.db.MovieDao
import com.arigarasuthan.asmovieclient.data.db.TvShowDao
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowDao.getTvShows()

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}