package com.learning.tmdbclient.presentation.di.core

import com.learning.tmdbclient.data.api.TMDBService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
//This Module provide 2 dependencies =>  1. Retrofit Instance 2. TMDBService instance
@Module
class NetModule(private val base_url: String) {
    // its very efficient keeping a single retrofit instance during the
    // entire operation time to do it using the singleton annotation

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        //construct  an instance using Builder function of Retrofit
        return Retrofit.Builder()                    //we need a convertor Factory to convert json into kotlin
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(base_url)                      // need a base url
            .build()
    }
    @Singleton
    @Provides
    fun provideTMDBService(retrofit: Retrofit):TMDBService{   // This function needs an instance of retrofit as a dependency.
        return retrofit.create(TMDBService::class.java)          // construct an instance using retrofit.create()
    }
}