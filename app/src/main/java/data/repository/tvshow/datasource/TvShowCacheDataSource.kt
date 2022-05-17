package data.repository.tvshow.datasource

import data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache():List<TvShow>
    suspend fun saveTvShowToCache(tvShow : List<TvShow>)
}