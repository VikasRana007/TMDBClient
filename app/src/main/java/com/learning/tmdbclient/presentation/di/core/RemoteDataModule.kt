package com.learning.tmdbclient.presentation.di.core

import com.learning.tmdbclient.data.api.TMDBService
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.learning.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.learning.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.learning.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.learning.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Provides
    @Singleton
    fun provideTvRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)
    }

    @Provides
    @Singleton
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)
    }

}