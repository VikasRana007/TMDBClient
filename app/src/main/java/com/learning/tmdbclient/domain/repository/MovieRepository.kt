package com.learning.tmdbclient.domain.repository

import data.model.movie.Movie

interface MovieRepository {
    /**
     * These repository interface will be implemented in the data layer and these use cases will be executed
     * from the view models of the presentation layer...
     */

    suspend fun getMovies():List<Movie>?

    suspend fun updateMovies():List<Movie>?

}