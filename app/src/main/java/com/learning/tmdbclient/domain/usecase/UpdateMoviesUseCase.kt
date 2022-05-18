package com.learning.tmdbclient.domain.usecase

import com.learning.tmdbclient.data.model.movie.Movie
import com.learning.tmdbclient.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}