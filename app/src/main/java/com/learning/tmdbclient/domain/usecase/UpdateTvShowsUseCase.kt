package com.learning.tmdbclient.domain.usecase

import com.learning.tmdbclient.domain.repository.TvShowRepository
import data.model.tvshow.TvShow

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}