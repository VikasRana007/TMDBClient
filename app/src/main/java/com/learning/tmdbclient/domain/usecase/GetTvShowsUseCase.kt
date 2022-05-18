package com.learning.tmdbclient.domain.usecase

import com.learning.tmdbclient.data.model.tvshow.TvShow
import com.learning.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? = tvShowRepository.getTvShows()

}