package com.learning.tmdbclient.presentation.di.core

import com.learning.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.learning.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.learning.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.learning.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.learning.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.learning.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.learning.tmdbclient.domain.repository.ArtistRepository
import com.learning.tmdbclient.domain.repository.MovieRepository
import com.learning.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }


    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}