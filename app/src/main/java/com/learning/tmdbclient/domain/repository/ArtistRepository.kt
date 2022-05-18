package com.learning.tmdbclient.domain.repository

import com.learning.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtist():List<Artist>?

    suspend fun updateArtist():List<Artist>?

}