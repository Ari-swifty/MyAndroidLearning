package com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasourceimpl

import com.arigarasuthan.asmovieclient.api.TMTBService
import com.arigarasuthan.asmovieclient.data.model.artist.ArtistList
import com.arigarasuthan.asmovieclient.data.repoimpl.artists.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistsRemoteDataSourceImpl(
    private val tmtbService: TMTBService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> = tmtbService.getPopularArtists(apiKey)
}