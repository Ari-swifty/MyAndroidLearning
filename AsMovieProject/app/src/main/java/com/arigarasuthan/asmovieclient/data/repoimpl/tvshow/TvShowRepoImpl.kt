package com.arigarasuthan.asmovieclient.data.repoimpl.tvshow

import android.util.Log
import com.arigarasuthan.asmovieclient.data.domain.repo.TvShowsRepo
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowCacheDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowLocalDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowRemoteDataSource

class TvShowRepoImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowsRepo {
    override suspend fun getTvShows(): List<TvShow>? = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI(): List<TvShow> {
        var tvShowList: List<TvShow> = ArrayList()

        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: java.lang.Exception) {
            Log.d("MyTag", exception.message.toString())
        }

        return tvShowList
    }

    suspend fun getTvShowsFromDB(): List<TvShow> {
        var tvShowList: List<TvShow> = ArrayList()

        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception: java.lang.Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    suspend fun getTvShowsFromCache(): List<TvShow> {
        var tvShowList: List<TvShow> = ArrayList()

        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception: java.lang.Exception) {
            Log.d("MyTag", exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }
}