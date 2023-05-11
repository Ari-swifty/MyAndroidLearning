package com.arigarasuthan.newsfeedapp.domain.usecases

import com.arigarasuthan.newsfeedapp.data.model.Article
import com.arigarasuthan.newsfeedapp.domain.repos.NewsRepo
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepo: NewsRepo) {
     fun execute() : Flow<List<Article>> = newsRepo.getSavedNews()
}