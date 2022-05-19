package com.learning.tmdbclient.data.repository.movie.datasourceImpl

import com.learning.tmdbclient.data.api.TMDBService
import com.learning.tmdbclient.data.model.movie.MovieList
import com.learning.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

        /**
         * here we can write the codes to invoke the getPopularMovies function of TMDBServices
         */
}