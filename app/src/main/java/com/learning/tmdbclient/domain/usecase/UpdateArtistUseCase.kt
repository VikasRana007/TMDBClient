package com.learning.tmdbclient.domain.usecase

import com.learning.tmdbclient.data.model.artist.Artist
import com.learning.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}