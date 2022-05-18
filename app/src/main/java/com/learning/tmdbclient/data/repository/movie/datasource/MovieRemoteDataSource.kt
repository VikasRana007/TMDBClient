package com.learning.tmdbclient.data.repository.movie.datasource

import com.learning.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}