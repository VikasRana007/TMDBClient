package com.learning.tmdbclient.data.repository.artist.datasourceImpl

import com.learning.tmdbclient.data.api.TMDBService
import com.learning.tmdbclient.data.model.artist.ArtistList
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)
}