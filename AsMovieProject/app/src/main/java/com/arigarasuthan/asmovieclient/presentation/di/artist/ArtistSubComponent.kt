package com.arigarasuthan.asmovieclient.presentation.di.artist

import com.arigarasuthan.asmovieclient.presentation.artists.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():ArtistSubComponent
    }
}