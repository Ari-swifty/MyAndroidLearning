package com.arigarasuthan.newsfeedapp.data.repo.datasource

import com.arigarasuthan.newsfeedapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
    fun getSavedData():Flow<List<Article>>
    suspend fun deleteArticle(article: Article)
}