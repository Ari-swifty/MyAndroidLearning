package com.arigarasuthan.newsfeedapp.domain.usecases

import com.arigarasuthan.newsfeedapp.data.model.APIResponse
import com.arigarasuthan.newsfeedapp.data.util.Resource
import com.arigarasuthan.newsfeedapp.domain.repos.NewsRepo

class GetSearchedNewsUseCase(private val newsRepo: NewsRepo) {
    suspend fun execute(searchQuery:String):Resource<APIResponse> = newsRepo.getSearchedNews(searchQuery)
}