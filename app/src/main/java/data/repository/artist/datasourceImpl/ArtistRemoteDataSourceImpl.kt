package data.repository.artist.datasourceImpl

import data.api.TMDBService
import data.model.artist.ArtistList
import data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)
}