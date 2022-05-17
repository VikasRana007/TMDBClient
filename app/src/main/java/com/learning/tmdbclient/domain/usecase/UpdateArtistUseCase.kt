package com.learning.tmdbclient.domain.usecase

import com.learning.tmdbclient.domain.repository.ArtistRepository
import data.model.artist.Artist

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtist()
}