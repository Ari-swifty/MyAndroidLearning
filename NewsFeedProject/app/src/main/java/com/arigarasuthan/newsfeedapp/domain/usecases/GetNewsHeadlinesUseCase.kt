package com.arigarasuthan.newsfeedapp.domain.usecases

import com.arigarasuthan.newsfeedapp.data.model.APIResponse
import com.arigarasuthan.newsfeedapp.data.util.Resource
import com.arigarasuthan.newsfeedapp.domain.repos.NewsRepo

class GetNewsHeadlinesUseCase(private val newsRepo: NewsRepo) {

    suspend fun execute(country:String,page:Int):Resource<APIResponse> = newsRepo.getNewsHeadlines(country,page)
}