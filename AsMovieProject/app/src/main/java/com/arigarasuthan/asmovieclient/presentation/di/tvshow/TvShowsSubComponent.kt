package com.arigarasuthan.asmovieclient.presentation.di.tvshow

import com.arigarasuthan.asmovieclient.presentation.tvshows.TvShowActivity
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowsModule::class])
interface TvShowsSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():TvShowsSubComponent
    }
}