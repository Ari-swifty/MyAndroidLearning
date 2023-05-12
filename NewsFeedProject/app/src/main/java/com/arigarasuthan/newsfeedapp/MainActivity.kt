package com.arigarasuthan.newsfeedapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.arigarasuthan.newsfeedapp.databinding.ActivityMainBinding
import com.arigarasuthan.newsfeedapp.presentation.adapter.NewsAdapter
import com.arigarasuthan.newsfeedapp.presentation.viewmodel.NewsViewModel
import com.arigarasuthan.newsfeedapp.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var factory: NewsViewModelFactory
    @Inject
    lateinit var newsAdapter: NewsAdapter
    lateinit var newsViewModel:NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.btnNews.setupWithNavController(navController)
        newsViewModel = ViewModelProvider(this,factory)[NewsViewModel::class.java]
    }
}