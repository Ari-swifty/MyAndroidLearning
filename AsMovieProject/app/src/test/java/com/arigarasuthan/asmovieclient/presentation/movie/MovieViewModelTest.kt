package com.arigarasuthan.asmovieclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.arigarasuthan.asmovieclient.data.domain.usecase.GetMovieUseCase
import com.arigarasuthan.asmovieclient.data.domain.usecase.UpdateMoviesUseCase
import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.repoimpl.movie.FakeMovieRepo
import com.arigarasuthan.asmovieclient.getOrAwaitValue
import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel


    @Before
    fun setUp() {
        val fakeMovieRepo = FakeMovieRepo()
        val getMoviesUseCase = GetMovieUseCase(fakeMovieRepo)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepo)
        movieViewModel = MovieViewModel(getMoviesUseCase,updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1,"Overview1","PosterPath1","Date1","Title1"))
        movies.add(Movie(2,"Overview2","PosterPath2","Date2","Title2"))

        val currentList = movieViewModel.getMovies().getOrAwaitValue()
        Truth.assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3,"Overview3","PosterPath3","Date3","Title3"))
        movies.add(Movie(4,"Overview4","PosterPath4","Date4","Title4"))

        val updatedList = movieViewModel.updateMovies().getOrAwaitValue()
        Truth.assertThat(updatedList).isEqualTo(movies)
    }

}