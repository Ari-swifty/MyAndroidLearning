package com.arigarasuthan.asmovieclient.presentation.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arigarasuthan.asmovieclient.R
import com.arigarasuthan.asmovieclient.databinding.ActivityTvShowBinding
import com.arigarasuthan.asmovieclient.presentation.di.Injector
import com.arigarasuthan.asmovieclient.presentation.movie.MovieAdapter
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory

    private lateinit var tvShowsViewModel: TvShowsViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowsViewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.apply {
            tvshowRecyclerview.layoutManager = LinearLayoutManager(this@TvShowActivity)
            adapter = TvShowAdapter()
            tvshowRecyclerview.adapter = adapter
        }
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.tvshowProgressbar.visibility = View.VISIBLE
        val responsesLiveData = tvShowsViewModel.getTvShows()
        responsesLiveData.observe(this) { tvShows ->
            if (tvShows != null) {
                adapter.setMovieList(tvShows)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressbar.visibility = View.GONE
            } else {
                binding.tvshowProgressbar.visibility = View.GONE
                Toast.makeText(this, "No data found", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun updateTvShows() {
        binding.tvshowProgressbar.visibility = View.VISIBLE
        val response = tvShowsViewModel.updateTvShows()
        response.observe(this) { tvShows ->
            if (tvShows != null) {
                adapter.setMovieList(tvShows)
                adapter.notifyDataSetChanged()
                binding.tvshowProgressbar.visibility = View.GONE
            } else {
                binding.tvshowProgressbar.visibility = View.GONE
            }
        }
    }


}