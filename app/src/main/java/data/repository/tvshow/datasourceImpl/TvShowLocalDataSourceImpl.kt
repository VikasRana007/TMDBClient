package data.repository.tvshow.datasourceImpl

import data.db.TvShowDao
import data.model.tvshow.TvShow
import data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowFromDB(): List<TvShow> {
        return tvShowDao.getAllTvShows()
    }

    override suspend fun saveTvShowToDB(tvShows: List<TvShow>) {
        CoroutineScope(IO).launch {
            tvShowDao.saveAllTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        tvShowDao.deleteAllTvShows()
    }
}