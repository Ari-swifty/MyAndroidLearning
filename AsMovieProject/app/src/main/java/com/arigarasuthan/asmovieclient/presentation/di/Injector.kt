package com.arigarasuthan.asmovieclient.presentation.di

import com.arigarasuthan.asmovieclient.presentation.di.artist.ArtistSubComponent
import com.arigarasuthan.asmovieclient.presentation.di.movie.MoviesSubComponent
import com.arigarasuthan.asmovieclient.presentation.di.tvshow.TvShowsSubComponent

interface Injector {
    fun createMovieSubComponent():MoviesSubComponent
    fun createTvShowSubComponent():TvShowsSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}