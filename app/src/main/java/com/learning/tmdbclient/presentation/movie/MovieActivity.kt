package com.learning.tmdbclient.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.learning.tmdbclient.R
import com.learning.tmdbclient.data.model.movie.Movie
import com.learning.tmdbclient.databinding.ActivityMovieBinding
import com.learning.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory : MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        // This below line mean we can Inject dependencies to this activity, lets inject MovieViewModelFactory
        (application as Injector).createMovieSubComponent().inject(this)
         movieViewModel = ViewModelProvider(this,factory).get(MovieViewModel::class.java)
        val responseLiveData : LiveData<List<Movie>?> = movieViewModel.getMovies()
        responseLiveData.observe(this) {
            Log.i("MovieList", it.toString())
        }
    }
}