package com.arigarasuthan.newsfeedapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arigarasuthan.newsfeedapp.data.util.Resource
import com.arigarasuthan.newsfeedapp.databinding.FragmentNewsBinding
import com.arigarasuthan.newsfeedapp.presentation.adapter.NewsAdapter
import com.arigarasuthan.newsfeedapp.presentation.viewmodel.NewsViewModel



class NewsFragment : Fragment() {
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var binding: FragmentNewsBinding
    private lateinit var adapter: NewsAdapter
    private var country = "us"
    private var page = 1
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
        initRecyclerView()
        viewNewsList()
    }

    private fun viewNewsList() {
        newsViewModel.getNewsHeadlines(country,page)
        newsViewModel.newsHeadlines.observe(viewLifecycleOwner) { response->
            when(response) {
                is Resource.Success -> {
                    hideLoading()
                    response.data?.let { apiResponse ->  
                        adapter.differ.submitList(apiResponse.articles.toList())
                    }
                }
                is Resource.Error -> {
                    hideLoading()
                    response.message?.let { msg->
                        Toast.makeText(activity,msg,Toast.LENGTH_LONG).show()
                    }
                }
                is Resource.Loading -> {
                    showLoading()
                }
            }
        }
    }

    private fun initRecyclerView() {
        adapter = NewsAdapter()
        binding.apply {
            rvNews.layoutManager = LinearLayoutManager(activity)
            rvNews.adapter = adapter
        }
    }

    private fun showLoading() {
        binding.rvProgressbar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.rvProgressbar.visibility = View.GONE
    }



}