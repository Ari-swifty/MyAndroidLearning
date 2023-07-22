package com.arigarasuthan.unitconverterapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ConversionResult::class], version = 1)
abstract class ConversionDataBase : RoomDatabase() {
    abstract val converterDAO:ConverterDAO

//    companion object {
//        @Volatile
//        private var INSTANCE:ConversionDataBase? = null
//        fun getInstance(context: Context):ConversionDataBase {
//            synchronized(this) {
//                var instance = INSTANCE
//                if(instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        ConversionDataBase::class.java,
//                        "converter_data_database"
//                    ).build()
//                }
//
//                return instance
//            }
//        }
//    }
}