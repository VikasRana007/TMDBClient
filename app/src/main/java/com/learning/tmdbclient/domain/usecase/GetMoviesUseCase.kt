package com.learning.tmdbclient.domain.usecase

import com.learning.tmdbclient.data.model.movie.Movie
import com.learning.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    /**
     * This class is use to get the movies list instance  a use case class can not do it without support of repository.
     * so we need a repository which has a function returns a list of movies instances. & we will be able to inject an
     * instance of that repository to the use case class a constructor parameter .
     */

    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}