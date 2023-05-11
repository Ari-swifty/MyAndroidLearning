package com.arigarasuthan.newsfeedapp.domain.usecases

import com.arigarasuthan.newsfeedapp.data.model.Article
import com.arigarasuthan.newsfeedapp.domain.repos.NewsRepo

class SaveNewsUseCase(private val newsRepo: NewsRepo) {
    suspend fun execute(article: Article) = newsRepo.saveNews(article)
}