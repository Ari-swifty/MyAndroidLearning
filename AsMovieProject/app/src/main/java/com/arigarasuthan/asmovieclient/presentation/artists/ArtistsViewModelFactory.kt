package com.arigarasuthan.asmovieclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arigarasuthan.asmovieclient.data.domain.usecase.GetArtistsUseCases
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateArtistsUseCase

class ArtistsViewModelFactory(
    private val getArtistsUseCases: GetArtistsUseCases,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCases, updateArtistsUseCase) as T
    }
}