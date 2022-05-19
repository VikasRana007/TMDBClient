package com.learning.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.learning.tmdbclient.data.model.artist.Artist
import com.learning.tmdbclient.domain.usecase.GetArtistUseCase
import com.learning.tmdbclient.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(private val getArtistUseCase: GetArtistUseCase,
                      private val updateArtistUseCase: UpdateArtistUseCase
) : ViewModel() {

    fun getArtist() = liveData {
        val artistList : List<Artist>? = getArtistUseCase.execute()
        emit(artistList)            // artist list as live data
    }

    fun updateArtistList() = liveData {
        val updateArtistList : List<Artist>? = updateArtistUseCase.execute()
        emit(updateArtistList)
    }
}