package com.learning.tmdbclient.data.repository.artist.datasource

import com.learning.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}