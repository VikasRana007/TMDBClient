package com.learning.tmdbclient.presentation.di.core

import com.learning.tmdbclient.data.db.ArtistDao
import com.learning.tmdbclient.data.db.MovieDao
import com.learning.tmdbclient.data.db.TvShowDao
import com.learning.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.learning.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.learning.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.learning.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatsSourceImpl
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.learning.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

// In this module we are going to construct and return this
// MovieLocalDataSourceImpl, TvShowLocalDataSourceImpl,ArtistLocalDataSourceImpl instances
@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDatsSourceImpl(movieDao)
    }


    @Singleton
    @Provides
    fun provideTvLocalDataSource(tvShowDao : TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }


    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}