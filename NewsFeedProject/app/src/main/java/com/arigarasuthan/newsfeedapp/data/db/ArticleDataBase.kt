package com.arigarasuthan.newsfeedapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.arigarasuthan.newsfeedapp.data.model.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)

@TypeConverters(Converters::class)
abstract class ArticleDataBase : RoomDatabase() {
    abstract fun getArticleDao():ArticleDao
}