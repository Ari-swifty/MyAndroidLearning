package com.arigarasuthan.asmovieclient.presentation.di.artist

import com.arigarasuthan.asmovieclient.data.domain.usecase.GetArtistsUseCases
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateArtistsUseCase
import com.arigarasuthan.asmovieclient.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCases: GetArtistsUseCases,
        updateArtistsUseCase: UpdateArtistsUseCase
    ) : ArtistsViewModelFactory {
        return ArtistsViewModelFactory(getArtistsUseCases,updateArtistsUseCase)
    }
}