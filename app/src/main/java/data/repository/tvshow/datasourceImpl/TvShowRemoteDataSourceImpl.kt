package data.repository.tvshow.datasourceImpl

import data.api.TMDBService
import data.model.tvshow.TvShowList
import data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService, private val apiKey: String) : TvShowRemoteDataSource {
    override suspend fun getTvShow(): Response<TvShowList> =  tmdbService.getPopularTvShows(apiKey)
        /**
         * here we can write the codes to invoke the getPopularTvShow function of TMDBServices
         */


}