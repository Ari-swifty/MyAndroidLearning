package com.arigarasuthan.roommigrationdemoapp

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 3, autoMigrations = [AutoMigration(from = 2, to = 3)])
abstract class StudentDataBase : RoomDatabase() {
    abstract val studentDAO:StudentDAO

    companion object {
        @Volatile
        private var INSTANCE : StudentDataBase? = null
        fun getInstance(context: Context) : StudentDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDataBase::class.java,
                        "student_data_base"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}