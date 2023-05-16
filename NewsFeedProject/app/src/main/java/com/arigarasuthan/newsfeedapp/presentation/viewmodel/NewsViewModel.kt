package com.arigarasuthan.newsfeedapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.arigarasuthan.newsfeedapp.data.model.APIResponse
import com.arigarasuthan.newsfeedapp.data.model.Article
import com.arigarasuthan.newsfeedapp.data.util.Resource
import com.arigarasuthan.newsfeedapp.domain.usecases.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
) : AndroidViewModel(app) {
    val newsHeadlines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadlines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadlines.postValue(Resource.Loading())
        try {
            if (isInternetAvailable(app)) {
                val apiResult = getNewsHeadlinesUseCase.execute(country, page)
                newsHeadlines.postValue(apiResult)
            } else {
                newsHeadlines.postValue(Resource.Error("Internet is not available"))
            }
        } catch (e: java.lang.Exception) {
            newsHeadlines.postValue(Resource.Error(e.message.toString()))
        }
    }

    @Suppress("DEPRECATION")
    fun isInternetAvailable(context: Context): Boolean {
        var result = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cm?.run {
                cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            }
        } else {
            cm?.run {
                cm.activeNetworkInfo?.run {
                    if (type == ConnectivityManager.TYPE_WIFI) {
                        result = true
                    } else if (type == ConnectivityManager.TYPE_MOBILE) {
                        result = true
                    }
                }
            }
        }
        return result
    }

    //Search news
    val searchNews: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun searchNews(country: String, searchQuery: String, page: Int) =
        viewModelScope.launch(Dispatchers.IO) {
            searchNews.postValue(Resource.Loading())
            try {
                if (isInternetAvailable(app)) {
                    val response = getSearchedNewsUseCase.execute(country, searchQuery, page)
                    searchNews.postValue(response)
                } else {
                    searchNews.postValue(Resource.Error("No Connection"))
                }
            } catch (e: java.lang.Exception) {
                searchNews.postValue(Resource.Error("Something went wrong"))
            }
        }

    //Local DataBase:Save News
    fun saveNewsToDB(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        saveNewsUseCase.execute(article)
    }

    //Local DataBase:Get Saved News
    fun getSavedNews() = liveData {
        getSavedNewsUseCase.execute().collect {
            emit(it)
        }
    }

    //Local DataBase:Delete News
    fun deleteArticles(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        deleteSavedNewsUseCase.execute(article)
    }
}