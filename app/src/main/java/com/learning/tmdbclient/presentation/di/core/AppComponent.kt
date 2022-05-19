package com.learning.tmdbclient.presentation.di.core

import com.learning.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.learning.tmdbclient.presentation.di.movie.MovieSubComponent
import com.learning.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        NetModule::class,
        CacheDataModule::class,
        DataBaseModule::class,
        LocalDataModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class]
)
interface AppComponent {
    // we need to create a new sub component and set the scope for ViewModel to limit the flow of
    // view model dependencies or instance
    // i.e movie data flow, artist data flow, tv show data flow
    // in this project we will create different sub components and scope for each of Movie,Artist,TvShow
    // here define function to get sub component factory

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvShowSubComponent():TvShowSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory
}