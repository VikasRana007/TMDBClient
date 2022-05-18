package com.learning.tmdbclient.domain.usecase

import com.learning.tmdbclient.data.model.tvshow.TvShow
import com.learning.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.updateTvShows()
}