package com.learning.tmdbclient.data.repository.tvshow.datasource

import com.learning.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}