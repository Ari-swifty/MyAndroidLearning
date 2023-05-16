package com.arigarasuthan.newsfeedapp.data.repo.datasourceimpl

import com.arigarasuthan.newsfeedapp.data.db.ArticleDao
import com.arigarasuthan.newsfeedapp.data.model.Article
import com.arigarasuthan.newsfeedapp.data.repo.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private val articleDao: ArticleDao) : NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedData(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }

    override suspend fun deleteArticle(article: Article) {
        return articleDao.deleteArticle(article)
    }
}