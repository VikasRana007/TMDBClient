package com.learning.tmdbclient.presentation.di.tvshow

import com.learning.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.learning.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.learning.tmdbclient.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}