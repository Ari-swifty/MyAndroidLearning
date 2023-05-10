package com.arigarasuthan.asmovieclient.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arigarasuthan.asmovieclient.R
import com.arigarasuthan.asmovieclient.data.model.artist.Artist
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow
import com.arigarasuthan.asmovieclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class ArtistsAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val artistsList = ArrayList<Artist>()

    fun setArtistList(artists:List<Artist>)
    {
        artistsList.clear()
        artistsList.addAll(artists)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = artistsList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistsList[position])
    }
}
class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(artist:Artist) {
        binding.apply {
            titleTextView.text = artist.name
            descriptionTextView.text = artist.popularity.toString()
            val postUrl = "https://image.tmdb.org/t/p/w500"+artist.profilePath
            Glide.with(imageView.context)
                .load(postUrl)
                .into(imageView)
        }
    }
}