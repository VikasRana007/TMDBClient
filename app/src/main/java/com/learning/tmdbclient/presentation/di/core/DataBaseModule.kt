package com.learning.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.learning.tmdbclient.data.db.ArtistDao
import com.learning.tmdbclient.data.db.MovieDao
import com.learning.tmdbclient.data.db.TMDBDatabase
import com.learning.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
                    // In this project we have 3 DAO interfaces local data source classes need them as dependencies.
                    // so need to create three provider functions to return those DAO dependencies.

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase):MovieDao{
        return tmdbDatabase.movieDao()
    }


    @Singleton
    @Provides
    fun provideTvDao(tmdbDatabase: TMDBDatabase):TvShowDao{
        return tmdbDatabase.tvDao()
    }


    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase):ArtistDao{
        return tmdbDatabase.artistDao()
    }
}