package com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource

import com.arigarasuthan.asmovieclient.data.model.artist.Artist
import com.arigarasuthan.asmovieclient.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}