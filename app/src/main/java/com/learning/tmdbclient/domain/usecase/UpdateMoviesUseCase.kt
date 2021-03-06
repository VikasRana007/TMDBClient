package com.learning.tmdbclient.domain.usecase

import com.learning.tmdbclient.domain.repository.MovieRepository
import data.model.movie.Movie

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}