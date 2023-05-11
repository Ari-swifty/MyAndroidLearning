package com.arigarasuthan.newsfeedapp.data.repo

import com.arigarasuthan.newsfeedapp.data.model.APIResponse
import com.arigarasuthan.newsfeedapp.data.model.Article
import com.arigarasuthan.newsfeedapp.data.repo.datasource.NewsRemoteDataSource
import com.arigarasuthan.newsfeedapp.data.util.Resource
import com.arigarasuthan.newsfeedapp.domain.repos.NewsRepo
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepoImpl(private val newsRemoteDataSource: NewsRemoteDataSource) : NewsRepo {
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country,page))
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    private fun responseToResource(response:Response<APIResponse>) : Resource<APIResponse> {
        if(response.isSuccessful) {
            response.body()?.let { ApiResponse->
                return Resource.Success(ApiResponse)
            }
        }
        return Resource.Error(response.message())
    }
}