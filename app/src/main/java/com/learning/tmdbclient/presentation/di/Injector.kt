package com.learning.tmdbclient.presentation.di

import com.learning.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.learning.tmdbclient.presentation.di.movie.MovieSubComponent
import com.learning.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}