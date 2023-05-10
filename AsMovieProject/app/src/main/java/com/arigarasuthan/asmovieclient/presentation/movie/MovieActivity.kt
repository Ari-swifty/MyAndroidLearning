package com.arigarasuthan.asmovieclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arigarasuthan.asmovieclient.R
import com.arigarasuthan.asmovieclient.databinding.ActivityMovieBinding
import com.arigarasuthan.asmovieclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding

    @Inject
    lateinit var factory: MovieViewModelFactory

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerview.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerview.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressbar.visibility = View.VISIBLE
        val responsesLiveData = movieViewModel.getMovies()
        responsesLiveData.observe(this) { movies ->
            if (movies != null) {
                adapter.setMovieList(movies)
                adapter.notifyDataSetChanged()
                binding.movieProgressbar.visibility = View.GONE
            } else {
                binding.movieProgressbar.visibility = View.GONE
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
        return when(item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressbar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this) { movies ->
            if (movies != null) {
                adapter.setMovieList(movies)
                adapter.notifyDataSetChanged()
                binding.movieProgressbar.visibility = View.GONE
            } else {
                binding.movieProgressbar.visibility = View.GONE

            }
        }
    }
}