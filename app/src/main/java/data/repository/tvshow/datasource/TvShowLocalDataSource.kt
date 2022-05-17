package data.repository.tvshow.datasource

import data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDB(): List<TvShow>
    suspend fun saveTvShowToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}