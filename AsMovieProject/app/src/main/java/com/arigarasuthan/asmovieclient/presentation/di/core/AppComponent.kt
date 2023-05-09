package com.arigarasuthan.asmovieclient.presentation.di.core

import com.arigarasuthan.asmovieclient.presentation.di.artist.ArtistSubComponent
import com.arigarasuthan.asmovieclient.presentation.di.movie.MoviesSubComponent
import com.arigarasuthan.asmovieclient.presentation.di.tvshow.TvShowsSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepoModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent():MoviesSubComponent.Factory
    fun tvshowSubComponent():TvShowsSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}