package com.learning.tmdbclient.domain.usecase

import com.learning.tmdbclient.data.model.artist.Artist
import com.learning.tmdbclient.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository : ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtist()
}