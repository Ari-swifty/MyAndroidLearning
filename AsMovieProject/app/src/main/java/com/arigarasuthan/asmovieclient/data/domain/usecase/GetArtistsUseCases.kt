package com.arigarasuthan.asmovieclient.data.domain.usecase

import com.arigarasuthan.asmovieclient.data.domain.repo.ArtistRepo
import com.arigarasuthan.asmovieclient.data.model.artist.Artist

class GetArtistsUseCases(private val artistRepo: ArtistRepo) {
    suspend fun execute():List<Artist>? = artistRepo.getArtists()

}