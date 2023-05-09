package com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasourceimpl

import com.arigarasuthan.asmovieclient.data.db.ArtistDao
import com.arigarasuthan.asmovieclient.data.model.artist.Artist
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistsLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}