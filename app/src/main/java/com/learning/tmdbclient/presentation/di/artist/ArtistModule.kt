package com.learning.tmdbclient.presentation.di.artist

import com.learning.tmdbclient.domain.usecase.GetArtistUseCase
import com.learning.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.learning.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideViewModelFactory(getArtistUseCase: GetArtistUseCase,
    updateArtistUseCase: UpdateArtistUseCase):ArtistViewModelFactory{
      return ArtistViewModelFactory(getArtistUseCase,updateArtistUseCase)
    }
}