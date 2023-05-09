package com.arigarasuthan.asmovieclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arigarasuthan.asmovieclient.data.domain.usecase.GetTvShowsUseCase
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getTvShowsUseCase,updateTvShowsUseCase) as T
    }
}