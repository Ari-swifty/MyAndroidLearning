package com.arigarasuthan.asmovieclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.arigarasuthan.asmovieclient.R
import com.arigarasuthan.asmovieclient.databinding.ActivityMovieBinding
import com.arigarasuthan.asmovieclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding

    @Inject
    lateinit var factory: MovieViewModelFactory

    private lateinit var movieViewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie)
        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this,factory)[MovieViewModel::class.java]
        val responsesLiveData = movieViewModel.getMovies()
        responsesLiveData.observe(this) { movies->
            Log.i("MYTAG",movies.toString())
        }

    }
}