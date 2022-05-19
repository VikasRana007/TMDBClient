package com.learning.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.learning.tmdbclient.data.model.movie.Movie
import com.learning.tmdbclient.domain.usecase.GetMoviesUseCase
import com.learning.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList: List<Movie>? = getMoviesUseCase.execute()
        emit((movieList))           // movie list as live data
    }

    fun updateMovieList() = liveData {
        val updateMovieList: List<Movie>? = updateMoviesUseCase.execute()
        emit(updateMovieList)      // updated movie list as live data

    }
}