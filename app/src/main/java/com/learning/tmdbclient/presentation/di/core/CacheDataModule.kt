package com.learning.tmdbclient.presentation.di.core

import com.learning.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.learning.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.learning.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.learning.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.learning.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    // creating cache data source impl instances are little bit easier than others
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }


    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}