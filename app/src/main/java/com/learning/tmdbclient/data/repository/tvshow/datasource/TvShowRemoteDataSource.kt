package com.learning.tmdbclient.data.repository.tvshow.datasource

import com.learning.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShow(): Response<TvShowList>
}