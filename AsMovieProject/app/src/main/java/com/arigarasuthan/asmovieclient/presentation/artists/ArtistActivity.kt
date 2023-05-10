package com.arigarasuthan.asmovieclient.presentation.artists

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
import com.arigarasuthan.asmovieclient.databinding.ActivityArtistBinding
import com.arigarasuthan.asmovieclient.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistsViewModelFactory

    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var adapter: ArtistsAdapter
    private lateinit var binding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.apply {
            artistRecyclerview.layoutManager = LinearLayoutManager(this@ArtistActivity)
            adapter = ArtistsAdapter()
            artistRecyclerview.adapter = adapter
        }
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.artistProgressbar.visibility = View.VISIBLE
        val responsesLiveData = artistViewModel.getArtists()
        responsesLiveData.observe(this) { artists ->
            if (artists != null) {
                adapter.setArtistList(artists)
                adapter.notifyDataSetChanged()
                binding.artistProgressbar.visibility = View.GONE
            } else {
                binding.artistProgressbar.visibility = View.GONE
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
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists() {
        binding.artistProgressbar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtists()
        response.observe(this) { artists ->
            if (artists != null) {
                adapter.setArtistList(artists)
                adapter.notifyDataSetChanged()
                binding.artistProgressbar.visibility = View.GONE
            } else {
                binding.artistProgressbar.visibility = View.GONE
            }
        }
    }

}