package com.arigarasuthan.asmovieclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.arigarasuthan.asmovieclient.data.domain.usecase.GetTvShowsUseCase
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData {
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}