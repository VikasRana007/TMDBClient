package com.learning.tmdbclient.data.repository.artist

import com.learning.tmdbclient.data.model.artist.Artist
import com.learning.tmdbclient.data.model.artist.ArtistList
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.learning.tmdbclient.domain.repository.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist> {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist> {
        val newListOfArtist = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfArtist)
        artistCacheDataSource.saveArtistToCache(newListOfArtist)
        return newListOfArtist
    }


    private suspend fun getArtistFromApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDataSource.getArtist()
            val body: ArtistList? = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
        }
        return artistList
    }

    private suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()

        } catch (exception: Exception) {
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    private suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistFromCache()

        } catch (exception: Exception) {
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
//            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }


}