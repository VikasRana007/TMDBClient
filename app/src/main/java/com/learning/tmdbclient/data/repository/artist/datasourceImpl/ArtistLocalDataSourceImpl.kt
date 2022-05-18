package com.learning.tmdbclient.data.repository.artist.datasourceImpl

import com.learning.tmdbclient.data.db.ArtistDao
import com.learning.tmdbclient.data.model.artist.Artist
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getAllArtists()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(IO).launch {
            artistDao.saveAllArtists(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}