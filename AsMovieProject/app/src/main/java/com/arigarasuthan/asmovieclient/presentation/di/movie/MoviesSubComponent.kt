package com.arigarasuthan.asmovieclient.presentation.di.movie

import com.arigarasuthan.asmovieclient.presentation.artists.ArtistActivity
import com.arigarasuthan.asmovieclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MoviesModule::class])
interface MoviesSubComponent {
    fun inject(moviesActivity:MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():MoviesSubComponent
    }
}