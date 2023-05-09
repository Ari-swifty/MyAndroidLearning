package com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasourceimpl

import com.arigarasuthan.asmovieclient.data.model.artist.Artist
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist>  = artistList

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}