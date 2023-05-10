package com.arigarasuthan.asmovieclient.data.repoimpl.movie

import com.arigarasuthan.asmovieclient.data.domain.repo.MovieRepo
import com.arigarasuthan.asmovieclient.data.model.movie.Movie

class FakeMovieRepo : MovieRepo {
    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1,"Overview1","PosterPath1","Date1","Title1"))
        movies.add(Movie(2,"Overview2","PosterPath2","Date2","Title2"))
    }
    override suspend fun getMovies(): List<Movie>?  = movies

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(3,"Overview3","PosterPath3","Date3","Title3"))
        movies.add(Movie(4,"Overview4","PosterPath4","Date4","Title4"))
        return movies
    }
}