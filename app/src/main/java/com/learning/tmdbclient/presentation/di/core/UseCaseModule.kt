package com.learning.tmdbclient.presentation.di.core

import com.learning.tmdbclient.domain.repository.ArtistRepository
import com.learning.tmdbclient.domain.repository.MovieRepository
import com.learning.tmdbclient.domain.repository.TvShowRepository
import com.learning.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    //  for movie data
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }


    // for tv show data

    @Provides
    fun provideGetTvShowUseCase(tvShowsUseCase: TvShowRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowsUseCase)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowsUseCase: TvShowRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowsUseCase)
    }

// for artist data

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }
}