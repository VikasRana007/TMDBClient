package com.learning.tmdbclient.domain.repository

import com.learning.tmdbclient.data.model.movie.Movie

interface MovieRepository {
    /**
     * These repository interface will be implemented in the com.learning.tmdbclient.data layer and these use cases will be executed
     * from the view models of the presentation layer...
     */

    suspend fun getMovies():List<Movie>?

    suspend fun updateMovies():List<Movie>?

}