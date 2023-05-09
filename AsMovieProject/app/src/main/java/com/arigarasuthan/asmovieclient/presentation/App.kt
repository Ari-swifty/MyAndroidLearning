package com.arigarasuthan.asmovieclient.presentation

import android.app.Application
import com.arigarasuthan.asmovieclient.BuildConfig
import com.arigarasuthan.asmovieclient.presentation.di.Injector
import com.arigarasuthan.asmovieclient.presentation.di.artist.ArtistSubComponent
import com.arigarasuthan.asmovieclient.presentation.di.core.*
import com.arigarasuthan.asmovieclient.presentation.di.movie.MoviesSubComponent
import com.arigarasuthan.asmovieclient.presentation.di.tvshow.TvShowsSubComponent
import dagger.internal.DaggerCollections

class App : Application(),Injector {
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }
    override fun createMovieSubComponent(): MoviesSubComponent  = appComponent.movieSubComponent().create()

    override fun createTvShowSubComponent(): TvShowsSubComponent = appComponent.tvshowSubComponent().create()

    override fun createArtistSubComponent(): ArtistSubComponent = appComponent.artistSubComponent().create()
}