package com.arigarasuthan.asmovieclient.presentation.di.tvshow

import com.arigarasuthan.asmovieclient.data.domain.usecase.GetTvShowsUseCase
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateTvShowsUseCase
import com.arigarasuthan.asmovieclient.presentation.tvshows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowsModule {

    @TvShowScope
    @Provides
    fun provideTvShowsViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ) : TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase,updateTvShowsUseCase)
    }
}