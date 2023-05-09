package com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasourceimpl

import com.arigarasuthan.asmovieclient.api.TMTBService
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShowList
import com.arigarasuthan.asmovieclient.data.repoimpl.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmtbService: TMTBService, private val apiKey:String) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> = tmtbService.getPopularTvShows(apiKey)
}