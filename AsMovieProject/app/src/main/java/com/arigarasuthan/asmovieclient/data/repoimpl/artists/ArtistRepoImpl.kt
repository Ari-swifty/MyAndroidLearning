package com.arigarasuthan.asmovieclient.data.repoimpl.artists

import android.util.Log
import com.arigarasuthan.asmovieclient.data.domain.repo.ArtistRepo
import com.arigarasuthan.asmovieclient.data.model.artist.Artist
import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistCacheDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistLocalDataSource
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistRemoteDataSource

class ArtistRepoImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepo {
    override suspend fun getArtists(): List<Artist>? = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI():List<Artist> {
        var artistList:List<Artist> = ArrayList()

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body!=null) {
                artistList = body.artists
            }
        }catch (exception:java.lang.Exception)
        {
            Log.d("MyTag",exception.message.toString())
        }

        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist> {
        var artistList:List<Artist> = ArrayList()

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (exception:java.lang.Exception)
        {
            Log.d("MyTag",exception.message.toString())
        }
        if(artistList.isNotEmpty()) {
            return artistList
        }
        else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    suspend fun getArtistsFromCache():List<Artist> {
        var artistList:List<Artist> = ArrayList()

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (exception:java.lang.Exception)
        {
            Log.d("MyTag",exception.message.toString())
        }
        if(artistList.isNotEmpty()) {
            return artistList
        }
        else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }
}