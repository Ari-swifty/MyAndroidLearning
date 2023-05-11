package com.arigarasuthan.newsfeedapp.domain.repos

import com.arigarasuthan.newsfeedapp.data.model.APIResponse
import com.arigarasuthan.newsfeedapp.data.model.Article
import com.arigarasuthan.newsfeedapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepo {
    suspend fun getNewsHeadlines(country:String,page:Int):Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery:String) : Resource<APIResponse>
    suspend fun saveNews(article:Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}