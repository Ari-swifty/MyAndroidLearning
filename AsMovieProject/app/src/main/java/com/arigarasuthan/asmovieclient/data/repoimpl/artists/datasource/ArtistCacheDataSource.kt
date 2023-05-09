package com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource

import com.arigarasuthan.asmovieclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}