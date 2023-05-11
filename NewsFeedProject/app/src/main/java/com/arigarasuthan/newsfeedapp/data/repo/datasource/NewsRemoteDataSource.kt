package com.arigarasuthan.newsfeedapp.data.repo.datasource

import com.arigarasuthan.newsfeedapp.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country:String,page:Int):Response<APIResponse>
}