package com.arigarasuthan.asmovieclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.arigarasuthan.asmovieclient.data.domain.usecase.GetArtistsUseCases
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCases: GetArtistsUseCases,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistList = getArtistsUseCases.execute()
        emit(artistList)
    }

    fun updateArtists() = liveData {
        val artistList = updateArtistsUseCase.execute()
        emit(artistList)
    }
}