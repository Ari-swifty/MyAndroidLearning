package com.arigarasuthan.asmovieclient.data.domain.usecase

import com.arigarasuthan.asmovieclient.data.domain.repo.TvShowsRepo
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow

class GetTvShowsUseCase(private val tvShowsRepo: TvShowsRepo) {
    suspend fun execute():List<TvShow>? = tvShowsRepo.getTvShows()

}