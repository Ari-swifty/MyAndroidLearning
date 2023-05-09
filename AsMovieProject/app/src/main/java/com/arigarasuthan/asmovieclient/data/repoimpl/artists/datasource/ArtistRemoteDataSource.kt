package com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource

import com.arigarasuthan.asmovieclient.data.model.artist.Artist
import com.arigarasuthan.asmovieclient.data.model.artist.ArtistList
import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>

}