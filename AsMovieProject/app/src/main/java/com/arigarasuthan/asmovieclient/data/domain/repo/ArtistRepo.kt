package com.arigarasuthan.asmovieclient.data.domain.repo

import com.arigarasuthan.asmovieclient.data.model.artist.Artist
import com.arigarasuthan.asmovieclient.data.model.movie.Movie

interface ArtistRepo {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}