package com.arigarasuthan.asmovieclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arigarasuthan.asmovieclient.data.model.artist.Artist
import com.arigarasuthan.asmovieclient.data.model.movie.Movie
import com.arigarasuthan.asmovieclient.data.model.tvshow.TvShow


@Database(entities = [Movie::class,TvShow::class,Artist::class], version = 1, exportSchema = false)
abstract class TMTBDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}