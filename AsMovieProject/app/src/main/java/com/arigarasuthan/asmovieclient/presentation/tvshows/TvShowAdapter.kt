package com.arigarasuthan.asmovieclient.presentation.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arigarasuthan.asmovieclient.R
import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow
import com.arigarasuthan.asmovieclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class TvShowAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()

    fun setMovieList(tvShows:List<TvShow>)
    {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = tvShowList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }
}
class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tvShow:TvShow) {
        binding.apply {
            titleTextView.text = tvShow.name
            descriptionTextView.text = tvShow.overview
            val postUrl = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
            Glide.with(imageView.context)
                .load(postUrl)
                .into(imageView)
        }
    }
}