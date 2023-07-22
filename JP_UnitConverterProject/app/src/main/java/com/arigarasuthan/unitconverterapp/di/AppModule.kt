package com.arigarasuthan.unitconverterapp.di

import android.app.Application
import androidx.room.Room
import com.arigarasuthan.unitconverterapp.data.ConversionDataBase
import com.arigarasuthan.unitconverterapp.data.ConversionRepo
import com.arigarasuthan.unitconverterapp.data.ConverterRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideConverterDataBase(app:Application) : ConversionDataBase {
        return Room.databaseBuilder(
            app,
            ConversionDataBase::class.java,
            "converter_data_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideConversionRepo(db:ConversionDataBase):ConversionRepo = ConverterRepoImpl(db.converterDAO)


}