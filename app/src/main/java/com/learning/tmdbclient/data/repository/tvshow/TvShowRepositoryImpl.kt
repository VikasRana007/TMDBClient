package com.learning.tmdbclient.data.repository.tvshow

import com.learning.tmdbclient.data.model.tvshow.TvShow
import com.learning.tmdbclient.data.model.tvshow.TvShowList
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.learning.tmdbclient.domain.repository.TvShowRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow> {
        return getTvShowFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow> {
        val newListOfTvShows: List<TvShow> = getTvShowFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTvShowFromApi(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemoteDataSource.getTvShow()
            val body: TvShowList? = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        } catch (exception: Exception) {
        }
        return tvShowList
    }

    private suspend fun getTvShowFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowFromDB()

        } catch (exception: Exception) {
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromApi()
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getTvShowFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()

        } catch (exception: Exception) {
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowFromDB()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
            tvShowLocalDataSource.saveTvShowToDB(tvShowList)
        }
        return tvShowList
    }
}