package data.repository.artist.datasource

import data.model.artist.Artist


interface ArtistCacheDataSource {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun saveArtistToCache(artist : List<Artist>)
}