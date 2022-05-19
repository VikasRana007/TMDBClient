package com.learning.tmdbclient.presentation.di.movie

import javax.inject.Scope

@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)       //this is customized annotation we can use this newly created Artist Scope as the
                                                                // scope of ArtistViewModelFactory dependency
annotation class MovieScope