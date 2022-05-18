package com.learning.tmdbclient.data.repository.movie

import android.util.Log
import com.learning.tmdbclient.data.model.movie.Movie
import com.learning.tmdbclient.data.model.movie.MovieList
import com.learning.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.learning.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.learning.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.learning.tmdbclient.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) :
    MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
         return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
         val newListOfMovie = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovie)
        movieCacheDataSource.saveMoviesToCache(newListOfMovie)
        return newListOfMovie
    }

    suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body: MovieList? = response.body()
            if (body != null) {
                movieList = body.movie
            }
        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        return movieList
    }


    suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }


    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()

        } catch (exception: Exception) {
            Log.i("MYTAG", exception.message.toString())
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }
}