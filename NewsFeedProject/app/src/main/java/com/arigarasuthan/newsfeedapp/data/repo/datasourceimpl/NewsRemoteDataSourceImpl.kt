package com.arigarasuthan.newsfeedapp.data.repo.datasourceimpl

import com.arigarasuthan.newsfeedapp.data.api.NewsApiService
import com.arigarasuthan.newsfeedapp.data.model.APIResponse
import com.arigarasuthan.newsfeedapp.data.repo.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsApiService: NewsApiService
) :
    NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsApiService.getTopHeadlines(country,page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsApiService.getSearchedTopHeadlines(country,searchQuery,page)
    }
}