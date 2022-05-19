package com.learning.tmdbclient.presentation

import android.app.Application
import com.learning.tmdbclient.BuildConfig
import com.learning.tmdbclient.presentation.di.Injector
import com.learning.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.learning.tmdbclient.presentation.di.core.*
import com.learning.tmdbclient.presentation.di.movie.MovieSubComponent
import com.learning.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    @Suppress("DEPRECATION")
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}