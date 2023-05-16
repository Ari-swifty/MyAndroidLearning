package com.arigarasuthan.newsfeedapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arigarasuthan.newsfeedapp.data.model.Article
import com.arigarasuthan.newsfeedapp.data.util.Resource
import com.arigarasuthan.newsfeedapp.databinding.FragmentNewsBinding
import com.arigarasuthan.newsfeedapp.presentation.adapter.NewsAdapter
import com.arigarasuthan.newsfeedapp.presentation.viewmodel.NewsViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class NewsFragment : Fragment() {
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: NewsAdapter
    private var country = "us"
    private var page = 1
    private var isScrolling = false
    private var isLoading = false
    private var isLastPage = false
    private var pages = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsBinding.bind(view)
        newsViewModel = (activity as MainActivity).newsViewModel
        adapter = (activity as MainActivity).newsAdapter
        adapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_article", it)
            }
            findNavController().navigate(R.id.action_newsFragment_to_infoFragment, bundle)
        }
        initRecyclerView()
        viewNewsList()
        setSearchView()
    }

    private fun viewNewsList() {
        newsViewModel.getNewsHeadlines(country, page)
        newsViewModel.newsHeadlines.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideLoading()
                    response.data?.let { apiResponse ->
                        adapter.differ.submitList(apiResponse.articles.toList())
                        Log.d("MyTResults", "${apiResponse.totalResults}")
                        pages = if (apiResponse.totalResults % 20 == 0) {
                            apiResponse.totalResults / 20
                        } else {
                            apiResponse.totalResults / 20 + 1
                        }
                        isLastPage = page == pages
                    }
                }
                is Resource.Error -> {
                    hideLoading()
                    response.message?.let { msg ->
                        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {
                    showLoading()
                }
            }
        }
    }

    //Search
    private fun setSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                newsViewModel.searchNews("us",p0.toString(),page)
                viewSearchedNews()
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                MainScope().launch {
                    delay(2000)
                    newsViewModel.searchNews("us",p0.toString(),page)
                    viewSearchedNews()
                }
                return false
            }

        })

        binding.searchView.setOnCloseListener(object :SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                initRecyclerView()
                viewNewsList()
                return false
            }

        })
    }

    private fun viewSearchedNews() {
        newsViewModel.searchNews.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    hideLoading()
                    response.data?.let { apiResponse ->
                        adapter.differ.submitList(apiResponse.articles.toList())
                        Log.d("MyTResults", "${apiResponse.totalResults}")
                        pages = if (apiResponse.totalResults % 20 == 0) {
                            apiResponse.totalResults / 20
                        } else {
                            apiResponse.totalResults / 20 + 1
                        }
                        isLastPage = page == pages
                    }
                }
                is Resource.Error -> {
                    hideLoading()
                    response.message?.let { msg ->
                        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {
                    showLoading()
                }
            }
        }

    }

    private fun initRecyclerView() {
        binding.apply {
            rvNews.layoutManager = LinearLayoutManager(activity)
            rvNews.adapter = adapter
            rvNews.addOnScrollListener(this@NewsFragment.onScrolllistener)
        }
    }

    private fun showLoading() {
        isLoading = true
        binding.rvProgressbar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        isLoading = false
        binding.rvProgressbar.visibility = View.GONE
    }

    private val onScrolllistener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = binding.rvNews.layoutManager as LinearLayoutManager
            val sizeOfTheCurrentList = layoutManager.itemCount
            val visibleItems = layoutManager.childCount
            val topPosition = layoutManager.findFirstVisibleItemPosition()

            val hasReachedToEnd = topPosition + visibleItems >= sizeOfTheCurrentList
            val shouldPaginate = !isLoading && !isLastPage && !hasReachedToEnd && isScrolling
            if (shouldPaginate) {
                page++
                newsViewModel.getNewsHeadlines(country, page)
                isScrolling = false
            }
        }
    }

}