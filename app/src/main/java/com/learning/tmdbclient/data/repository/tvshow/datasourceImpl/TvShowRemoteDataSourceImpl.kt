package com.learning.tmdbclient.data.repository.tvshow.datasourceImpl

import com.learning.tmdbclient.data.api.TMDBService
import com.learning.tmdbclient.data.model.tvshow.TvShowList
import com.learning.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) : TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList> =  tmdbService.getPopularTvShows(apiKey)
        /**
         * here we can write the codes to invoke the getPopularTvShow function of TMDBServices
         */


}