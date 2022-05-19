package com.learning.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.learning.tmdbclient.data.model.tvshow.TvShow
import com.learning.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.learning.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(private val getTvShowsUseCase: GetTvShowsUseCase, private val updateTvShowsUseCase: UpdateTvShowsUseCase ):ViewModel() {

    fun getTvShow() = liveData {
        val tvShowList : List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowList)            // tvShow list as live data
    }

    fun updateTvShowList() = liveData {
        val updateTvShowList : List<TvShow>? = updateTvShowsUseCase.execute()
        emit(updateTvShowList)
    }



}