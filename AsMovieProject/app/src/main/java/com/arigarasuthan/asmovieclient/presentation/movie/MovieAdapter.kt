package com.arigarasuthan.asmovieclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arigarasuthan.asmovieclient.R
import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.databinding.ListItemBinding
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setMovieList(movies:List<Movie>)
    {
        movieList.clear()
        movieList.addAll(movies)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }
}
class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie:Movie) {
        binding.apply {
            titleTextView.text = movie.title
            descriptionTextView.text = movie.overview
            val postUrl = "https://image.tmdb.org/t/p/w500"+movie.posterPath
            Glide.with(imageView.context)
                .load(postUrl)
                .into(imageView)
        }
    }
}