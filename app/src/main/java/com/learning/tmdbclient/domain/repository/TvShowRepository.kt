package com.learning.tmdbclient.domain.repository

import com.learning.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows(): List<TvShow>?

    suspend fun updateTvShows(): List<TvShow>?

}