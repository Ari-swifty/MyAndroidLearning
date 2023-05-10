package com.arigarasuthan.asmovieclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieDao: MovieDao
    private lateinit var dataBase: TMTBDataBase

    @Before
    fun setUp() {
        dataBase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMTBDataBase::class.java
        ).build()
        movieDao = dataBase.movieDao()
    }

    @After
    fun tearDown() {
        dataBase.close()
    }

    @Test
    fun saveMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1,"Overview1","PosterPath1","date1","Title1"),
            Movie(2,"Overview2","PosterPath2","date2","Title2"),
            Movie(3,"Overview3","PosterPath3","date3","Title3"),
        )
        movieDao.saveMovies(movies)

        val allMovies = movieDao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest() = runBlocking {
        val movies = listOf(
            Movie(1,"Overview1","PosterPath1","date1","Title1"),
            Movie(2,"Overview2","PosterPath2","date2","Title2"),
            Movie(3,"Overview3","PosterPath3","date3","Title3"),
        )

        movieDao.saveMovies(movies)
        movieDao.deleteAllMovies()
        val movieResult = movieDao.getMovies()
        Truth.assertThat(movieResult).isEmpty()
    }
}