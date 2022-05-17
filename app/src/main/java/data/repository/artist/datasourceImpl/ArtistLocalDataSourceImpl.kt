package data.repository.artist.datasourceImpl

import data.db.ArtistDao
import data.model.artist.Artist
import data.repository.artist.datasource.ArtistLocalDataSource

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao) : ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getAllArtists()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        artistDao.saveAllArtists(artist)
    }

    override suspend fun clearAll() {
        artistDao.deleteAllArtist()
    }
}