package com.learning.tmdbclient.presentation.di.movie

import com.learning.tmdbclient.domain.usecase.GetMoviesUseCase
import com.learning.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.learning.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideViewModelFactory(
        getMovieUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMovieUseCase, updateMoviesUseCase)
    }
}