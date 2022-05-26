package com.learning.tmdbclient.presentation.tv

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.learning.tmdbclient.R
import com.learning.tmdbclient.data.model.tvshow.TvShow
import com.learning.tmdbclient.databinding.ActivityTvShowBinding
import com.learning.tmdbclient.presentation.di.Injector
import javax.inject.Inject

@SuppressLint("NotifyDataSetChanged")
class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var adapter: TvShowAdapter
    private lateinit var viewModel: TvShowViewModel
    private lateinit var binding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        // This below line mean we can Inject dependencies to this activity, lets inject MovieViewModelFactory
        (application as Injector).createTvShowSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        // initialise adapter
        adapter = TvShowAdapter()
        // set the adapter to recycler view
        binding.tvRecyclerView.adapter = adapter
        displayPopularTvShow()
    }

    private fun displayPopularTvShow() {
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData: LiveData<List<TvShow>?> = viewModel.getTvShow()
        responseLiveData.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                binding.tvProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_update -> {
                updateArtist()
            }
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }

    private fun updateArtist() {
        binding.tvProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<TvShow>?> = viewModel.updateTvShowList()
        response.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            } else {
                binding.tvProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }

        }

    }
}