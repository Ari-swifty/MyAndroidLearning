package com.arigarasuthan.asmovieclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.arigarasuthan.asmovieclient.R
import com.arigarasuthan.asmovieclient.databinding.ActivityHomeBinding
import com.arigarasuthan.asmovieclient.presentation.artists.ArtistActivity
import com.arigarasuthan.asmovieclient.presentation.movie.MovieActivity
import com.arigarasuthan.asmovieclient.presentation.tvshows.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)
        binding.apply {
            movieButton.setOnClickListener {
                val intent = Intent(this@HomeActivity,MovieActivity::class.java)
                startActivity(intent)
            }
            tvButton.setOnClickListener {
                val intent = Intent(this@HomeActivity,TvShowActivity::class.java)
                startActivity(intent)
            }
            artistsButton.setOnClickListener {
                val intent = Intent(this@HomeActivity,ArtistActivity::class.java)
                startActivity(intent)
            }
        }
    }
}