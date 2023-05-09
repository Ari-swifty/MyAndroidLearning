package com.arigarasuthan.asmovieclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.arigarasuthan.asmovieclient.data.db.ArtistDao
import com.arigarasuthan.asmovieclient.data.db.MovieDao
import com.arigarasuthan.asmovieclient.data.db.TMTBDataBase
import com.arigarasuthan.asmovieclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context): TMTBDataBase {
        return Room.databaseBuilder(context, TMTBDataBase::class.java, "tmtbclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmtbDataBase: TMTBDataBase):MovieDao {
        return tmtbDataBase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmtbDataBase: TMTBDataBase):TvShowDao {
        return tmtbDataBase.tvShowDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmtbDataBase: TMTBDataBase):ArtistDao {
        return tmtbDataBase.artistDao()
    }




}