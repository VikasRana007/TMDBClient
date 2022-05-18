package com.learning.tmdbclient.data.repository.tvshow.datasource

import com.learning.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(tvShow : List<TvShow>)
}